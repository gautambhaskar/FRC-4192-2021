/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.testingSystem;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TestingSystem;

public class TestMotor extends CommandBase {
  private final TestingSystem m_motor;
  private final double m_speed;

  /**
   * Creates a new TestMotor.
   */
  public TestMotor(TestingSystem subsystem, double speed) {
    m_motor = subsystem;
    m_speed = speed;
    addRequirements(m_motor);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_motor.runMotor(m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_motor.runMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
