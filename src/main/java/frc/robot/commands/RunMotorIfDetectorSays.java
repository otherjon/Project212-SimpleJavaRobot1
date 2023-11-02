// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants.Outputs;
import frc.robot.subsystems.DetectorSubsystem;
import frc.robot.subsystems.MotorSubsystem;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class RunMotorIfDetectorSays extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DetectorSubsystem local_detector_sub;
  private final MotorSubsystem local_motor_sub;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RunMotorIfDetectorSays(DetectorSubsystem d_sub, MotorSubsystem m_sub) {
    local_detector_sub = d_sub;
    local_motor_sub = m_sub;

    // Use addRequirements() here to declare subsystem dependencies.
    // Another command can use the detector in parallel with this command, so
    //  it isn't a dependency.

    addRequirements(local_motor_sub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (local_detector_sub.something_is_near()) {
        local_motor_sub.set_target_speed(Outputs.MOTOR_SPEED);
    } else {
      local_motor_sub.set_target_speed(0.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
