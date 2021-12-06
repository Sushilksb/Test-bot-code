// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;

public class DriveWithJoystick extends CommandBase {
  /** Creates a new DriveWithJoystick. */
  private DriveSystem motorSpin;
  private XboxController joy;

  public DriveWithJoystick(DriveSystem spinning, XboxController joy) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.joy = joy;
    motorSpin = spinning;

    addRequirements(spinning);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //motorSpin.spinningMotor(0.5);
    // && joy.getY(Hand.kRight) < -0.15
    boolean rightDeadzone = joy.getY(Hand.kRight) >= 0.2 || joy.getY(Hand.kRight) <= -0.2;
    boolean leftDeadzone = joy.getY(Hand.kLeft) >= 0.2 || joy.getY(Hand.kLeft) <= -0.2;
    if ((leftDeadzone) || (rightDeadzone))
    {
      motorSpin.differentialTank(joy.getY(Hand.kLeft), joy.getY(Hand.kRight));
    }

    else
    {
      motorSpin.differentialTank(0, 0);
    }
      //motorSpin.differentialTank(joy.getY(Hand.kLeft), joy.getY(Hand.kRight));
      //joy.getY(Hand.kRight
      //motorSpin.spinningLeftMotor(joy.getY(Hand.kRight));
  
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motorSpin.spinningLeftMotor(0.0);
    motorSpin.spinningRightMotor(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
