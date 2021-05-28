/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.PunchOut;
import frc.robot.commands.PunchIn;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LaserSubsystem;
import frc.robot.subsystems.LinearActuatorSubsystem;
import frc.robot.commands.ManualRollIntake;

public class RobotContainer {

  public static XboxController controller = new XboxController(0);
  public static CameraSubsystem cameraSubsystem = new CameraSubsystem();
  public static LaserSubsystem laserSubsystem = new LaserSubsystem();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public static LinearActuatorSubsystem actuatorSubsystem = new LinearActuatorSubsystem();
  
  public RobotContainer() {
    configureButtonBindings(); 
    intakeSubsystem.setDefaultCommand( new ManualRollIntake(intakeSubsystem));
  }

  private void configureButtonBindings() {

    new JoystickButton(controller, Button.kY.value).whenPressed(new PunchOut());
    new JoystickButton(controller, Button.kA.value).whenPressed(new PunchIn());
  }

}
