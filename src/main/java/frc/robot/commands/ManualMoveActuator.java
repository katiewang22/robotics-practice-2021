// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LinearActuatorSubsystem;

public class ManualMoveActuator extends CommandBase {

  private final LinearActuatorSubsystem actuator;
  private static XboxController controller = RobotContainer.controller;

  double rightStickYValue;
  double leftStickYValue;

  double vertPower;
  double boomPower;

  double boomEncoderCounts;
  double vertEncoderCounts;

  public ManualMoveActuator(LinearActuatorSubsystem linearActuator) {
    actuator = linearActuator;
    addRequirements(actuator);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {

    rightStickYValue = controller.getY(Hand.kRight);
    leftStickYValue = controller.getY(Hand.kLeft);

    vertPower = rightStickYValue;
    boomPower = leftStickYValue;

    if (Math.abs(vertPower) < 0.2) {
      vertPower = 0;
    } if (Math.abs(boomPower) < 0.2) {
      boomPower = 0;
    }

    final double MAX_ENC_BOOM = 400;
    final double MAX_ENC_VERT = 400;

    boomEncoderCounts = actuator.getBoomEncoder();
    vertEncoderCounts = actuator.getVertEncoder();

    if (boomEncoderCounts > MAX_ENC_BOOM) {
      boomPower = 0;
    } if (vertEncoderCounts < MAX_ENC_VERT) {
      vertPower = 0;
    }

    actuator.setVertPower(vertPower);
    actuator.setBoomPower(boomPower);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
