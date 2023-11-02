// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MotorSubsystem extends SubsystemBase {
  public WPI_TalonSRX controller;
  public double target_speed = 0.0;

  /** Creates a new MotorSubsystem. */
  public MotorSubsystem(int can_bus_id) {
    controller = new WPI_TalonSRX(can_bus_id);
    SmartDashboard.putNumber("Motor target speed", target_speed);
  }

  public void set_target_speed(double value) {
    target_speed = value;
  }

  @Override
  public void periodic() {
    controller.set(target_speed);
    SmartDashboard.putNumber("Motor target speed", target_speed);
  }
}