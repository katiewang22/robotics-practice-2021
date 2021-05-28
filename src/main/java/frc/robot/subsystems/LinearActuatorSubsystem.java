package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LinearActuatorSubsystem extends SubsystemBase {

    private static final int TIMEOUT_MS = 10;
    public static final double MAX_ENC_COUNTS = 4096;

    public static WPI_TalonSRX boomMotor = RobotMap.boomLinearActuatorMotor;
    public static WPI_TalonSRX vertMotor = RobotMap.vertLinearActuatorMotor;

    public LinearActuatorSubsystem() { 
        vertMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, TIMEOUT_MS);
        boomMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, TIMEOUT_MS);

        vertMotor.set(ControlMode.PercentOutput, 0);
        boomMotor.set(ControlMode.PercentOutput, 0);

        vertMotor.setSensorPhase(true);
        boomMotor.setSensorPhase(true);
    }

    public static double getBoomEncoder() {
        return(boomMotor.getSensorCollection().getQuadraturePosition());
    }
    
    public static double getVertEncoder() {
        return(vertMotor.getSensorCollection().getQuadraturePosition());
    }

    public void setVertPower(double power) {
        vertMotor.set(power);
    }

    public void setBoomPower(double power) {
        boomMotor.set(power);
    }

    public void stop() {
        vertMotor.set(0.0);
        boomMotor.set(0.0);
    }

    public static double getBoomEncoderRevolutions() {
        double boomRevolutions = getVertEncoder() / MAX_ENC_COUNTS;
        return(boomRevolutions);
    }

    public static double getVertEncoderRevolutions() {
        double vertRevolutions = getBoomEncoder() / MAX_ENC_COUNTS;
        return(vertRevolutions);
    }

    @Override
    public void periodic() {

    }
}