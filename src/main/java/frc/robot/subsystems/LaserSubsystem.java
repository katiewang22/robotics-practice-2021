package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LaserSubsystem extends SubsystemBase {

    public static double INCHES_PER_VOLT_DIRECT_CURRENT = 28.9;
    public static double CONST_OF_0_VOLTS = 2.78;
    
    public static double getLaserDistance() {
        double volts = RobotMap.laserVision.getAverageVoltage();
        double distanceOfLaser = (volts * INCHES_PER_VOLT_DIRECT_CURRENT) + CONST_OF_0_VOLTS;
        return (distanceOfLaser);
    }

    public double getLaserVoltage() {
        double volts = RobotMap.laserVision.getAverageVoltage();
        return(volts);
    }

    @Override
    public void periodic() {

    }
}