package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class ManualRollIntake extends CommandBase {

    private final IntakeSubsystem intakeSubsystem;
    private final static XboxController manipulator = RobotContainer.controller; 

    public ManualRollIntake(IntakeSubsystem intake) {
        intakeSubsystem = intake;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        boolean mLeftTrigger = manipulator.getTriggerAxis(Hand.kLeft) > 0.25;
        boolean mRightTrigger = manipulator.getTriggerAxis(Hand.kRight) > 0.25;

        if (mLeftTrigger) {
            IntakeSubsystem.spinInwards();
        } else if ( mRightTrigger ) {
            IntakeSubsystem.spinOutwards();
        } else {
            IntakeSubsystem.stop();
        }
    }
}