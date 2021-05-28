package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.AnalogInput;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RobotMap {
    public static Solenoid punchSolenoid = new Solenoid(0, 4);
    public static AnalogInput laserVision = new AnalogInput(3);

    public static final int LEFT_INTAKE = 21;
    public static final int RIGHT_INTAKE = 22;
    public static final int VERT_ACTUATOR = 13;
    public static final int BOOM_ACTUATOR = 23;

    public static WPI_TalonSRX leftIntakeWheel = new WPI_TalonSRX(LEFT_INTAKE);
    public static WPI_TalonSRX rightIntakeWheel = new WPI_TalonSRX(RIGHT_INTAKE);
    public static WPI_TalonSRX boomLinearActuatorMotor = new WPI_TalonSRX(BOOM_ACTUATOR);
    public static WPI_TalonSRX vertLinearActuatorMotor = new WPI_TalonSRX(VERT_ACTUATOR);
}