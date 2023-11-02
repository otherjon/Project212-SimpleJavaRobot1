// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DetectorSubsystem extends SubsystemBase {
  public DigitalInput sensor;
  public boolean sensorValue;

  /** Creates a new DetectorSubsystem. */
  public DetectorSubsystem(int digitalIO_port) {
    sensor = new DigitalInput(digitalIO_port);
    // The sensor is inverted!  It returns True if nothing is detected,
    // and returns False if something is detected.  So we negate the
    // value returned by get(), by using "!" (logical NOT).
    sensorValue = !sensor.get();
    SmartDashboard.putBoolean("Sensor value", sensorValue);
  }

  public boolean something_is_near() {
    return sensorValue;
  }

  @Override
  public void periodic() {
    // The sensor is inverted!  It returns True if nothing is detected,
    // and returns False if something is detected.  So we negate the
    // value returned by get(), by using "!" (logical NOT).
    sensorValue = !sensor.get();
    SmartDashboard.putBoolean("Sensor value", sensorValue);
  }
}
