package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;

public class CameraSubsystem extends SubsystemBase {
    
    public CameraSubsystem() {
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture("driverCam", "/dev/video0");
        camera.setResolution(480, 360);
        camera.setFPS(8);
    }

    @Override
    public void periodic() {

    }
}