/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.drivePID;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DriveForDistance extends PIDCommand {
  /**
   * Creates a new DriveForDistance.
   */
  public DriveForDistance(Drivetrain m_drive, double m_distance) {
    super(
        // The controller that the command will use
        new PIDController(0.005, 0, 0),
        // This should return the measurement
        () -> m_drive.returnDrivetrainPosition(),
        // This should return the setpoint (can also be a constant)
        () -> m_distance,
        // This uses the output
        output -> {
          if (output > drivePID.autonMaxSpeed) {
            m_drive.arcadeDrive(drivePID.autonMaxSpeed, -drivePID.kP * m_drive.returnAngle());
          } else if (output < -drivePID.autonMaxSpeed) {
            m_drive.arcadeDrive(-drivePID.autonMaxSpeed, -drivePID.kP * m_drive.returnAngle());
          } else {
            m_drive.arcadeDrive(output, -drivePID.kP * m_drive.returnAngle());
          }
        });
    m_drive.recalibratePosition();
    m_drive.recalibrateAngle();
    addRequirements(m_drive);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(0.05);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}