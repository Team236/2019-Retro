/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoysticks;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  // Declare drive motor controllers
  private TalonSRX leftFront, rightFront;
  private VictorSPX leftRear, rightRear;

  public Drive() {
    // Initialize motor controllers using ID's stored in RobotMap
    leftFront = new TalonSRX(RobotMap.ID_LEFT_FRONT);
    leftRear = new VictorSPX(RobotMap.ID_LEFT_REAR);
    rightFront = new TalonSRX(RobotMap.ID_RIGHT_FRONT);
    rightRear = new VictorSPX(RobotMap.ID_RIGHT_REAR);

    // Set rear controllers to follow front
    leftRear.follow(leftFront);
    rightRear.follow(rightFront);
  }

  // Methods to set speed of left and right motor controllers
  public void setLeftSpeed(double speed) {
    leftFront.set(ControlMode.PercentOutput, speed);
  }

  public void setRightSpeed(double speed) {
    rightFront.set(ControlMode.PercentOutput, speed);
  }

  // Method to set both sides' speeds to 0
  public void stop() {
    setLeftSpeed(0);
    setRightSpeed(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveWithJoysticks());
  }
}
