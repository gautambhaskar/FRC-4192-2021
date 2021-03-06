package frc.robot;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.Constants.limelightPID;

public class Globals {
    public static class LimelightShuffleboard {
        public static NetworkTableEntry kP = Shuffleboard.getTab("Main").add("Limelight P", limelightPID.kP).getEntry();
        public static NetworkTableEntry kI = Shuffleboard.getTab("Main").add("Limelight I", limelightPID.kI).getEntry();
        public static NetworkTableEntry kD = Shuffleboard.getTab("Main").add("Limelight D", limelightPID.kD).getEntry();
    }
    public static NetworkTableEntry shotBalls = Shuffleboard.getTab("Tuning").add("Ball Counter", 0).getEntry();
    public static NetworkTableEntry goodFrames = Shuffleboard.getTab("Tuning").add("Good Frames", 0).getEntry();
    public static NetworkTableEntry chosenAuton = Shuffleboard.getTab("Main").add("Selected Autonomous", "None").getEntry();

    public static double flyWheelSpeed = 0;
    public static double feederSpeed = 0;
    public static int pathChosen = 0; // 0-none, 1-blueA, 2-blueB, 3-redA, 4-redB
    public static double totalFeederSpeed = 0;
    public static double numIterations = 0;
    public static double averageFeederSpeed = 0; 
    public static boolean drivetrainDistanceReached = false;
    public static int ballsShot = 0;
    public static int goodFrameCounter = 0;
    public static String selectedAuton = "None";
    // Used to turn on intake once the drive has reached 50% of the desired distance
    // in DriveAndIntake
}
