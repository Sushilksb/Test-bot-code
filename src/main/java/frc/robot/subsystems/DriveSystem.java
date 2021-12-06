// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveSystem extends SubsystemBase {
  /** Creates a new DriveSystem. */
  // Creating Motors
  private WPI_TalonSRX rightFrontMotor;
  private WPI_TalonSRX leftMotor;
  private WPI_TalonSRX elevatorMotor;

  DifferentialDrive differentialDrive;

  private DigitalInput limitSwitch;

  //private AnalogPotentiometer potentiometer;

  public DriveSystem() {
    // Instaniating motors
    rightFrontMotor = new WPI_TalonSRX(Constants.RIGHT_SIDE_MOTOR);
    rightFrontMotor.setInverted(true);

    leftMotor = new WPI_TalonSRX(Constants.LEFT_SIDE_MOTOR);
    leftMotor.setInverted(false);

    elevatorMotor = new WPI_TalonSRX(Constants.ELEVATOR_MOTOR);

    limitSwitch = new DigitalInput(1);

    differentialDrive = new DifferentialDrive(rightFrontMotor, leftMotor);

    //potentiometer = new AnalogPotentiometer(0, 12, 15);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // This line will make the rightFrontMotor spin
  public void spinningMotor(double speed)
  {
    rightFrontMotor.set(speed);
    leftMotor.set(speed);    
    differentialDrive.tankDrive(0.5, 0.5);
    //differentialDrive.arcadeDrive(xSpeed, zRotation);
    //differentialDrive.curvatureDrive(xSpeed, zRotation, isQuickTurn);
  }

  public void differentialTank(double leftspeed, double rightspeed)
  {
    differentialDrive.tankDrive(leftspeed, rightspeed);
  }

  public void spinningRightMotor(double speed)
  {

    //if (potentiometer.get() >= )

    if (!limitSwitch.get())
    {
      rightFrontMotor.set(ControlMode.PercentOutput, 0);
    }
    else
    {
      rightFrontMotor.set(ControlMode.PercentOutput, speed);
    }
    //rightFrontMotor.set(ControlMode.PercentOutput, speed);
  }
  
  public void spinningLeftMotor(double speed)
  {
    if (!limitSwitch.get())
    {
      leftMotor.set(ControlMode.PercentOutput, 0);
    }
    else
    {
      leftMotor.set(ControlMode.PercentOutput, speed);
    }
    //leftMotor.set(ControlMode.PercentOutput, speed);
  }

  public void spinningElevatorMotor(double speed)
  {
    elevatorMotor.set(ControlMode.PercentOutput, speed);
  }

}
