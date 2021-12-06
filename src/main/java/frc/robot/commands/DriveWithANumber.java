// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;

public class DriveWithANumber extends CommandBase {
  /** Creates a new DriveWithANumber. */

  private DriveSystem driving;
  private double speed;

  public DriveWithANumber(DriveSystem driving, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driving = driving;
    this.speed = speed;

    addRequirements(driving);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driving.differentialTank(speed, speed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driving.differentialTank(0.0, 0.0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
