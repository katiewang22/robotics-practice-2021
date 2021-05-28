package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeSubsystem extends SubsystemBase {

    public static double IN_POWER = 0.75;
    public static double OUT_POWER = 0.565;

    public static WPI_TalonSRX leftIntakeWheel = RobotMap.leftIntakeWheel;
    public static WPI_TalonSRX rightIntakeWheel = RobotMap.rightIntakeWheel;

    public IntakeSubsystem() {
        leftIntakeWheel.setInverted(true);
        rightIntakeWheel.setInverted(false);
    }

    public static void spinInwards() {
        leftIntakeWheel.set(IN_POWER);
        rightIntakeWheel.set(IN_POWER);
    }

    public static void spinOutwards() {
        leftIntakeWheel.set(OUT_POWER);
        rightIntakeWheel.set(OUT_POWER);
    }

    public static void stop() {
        leftIntakeWheel.set(0);
        rightIntakeWheel.set(0);
    }

    @Override
    public void periodic() {

    }
}