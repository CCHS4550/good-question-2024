package frc.ControlScheme;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import frc.helpers.ControlScheme;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import static edu.wpi.first.wpilibj2.command.Commands.parallel;
import static edu.wpi.first.wpilibj2.command.Commands.runOnce;
import static edu.wpi.first.wpilibj2.command.Commands.sequence;
import static edu.wpi.first.wpilibj2.command.Commands.waitSeconds;

public class mechanismScheme implements ControlScheme {
    private static CommandGenericHID buttonBoard;
    
    public static void configure(Intake intake, Indexer indexer, Shooter shooter, int port){
        buttonBoard = new CommandGenericHID(port);
        configureButtons(intake, indexer, shooter, port);
    }

    private static void configureButtons(Intake intake, Indexer indexer, Shooter shooter, int port) {
        
        Command shoot = parallel(
            shooter.revForTime(0.8, 3.0),
            sequence(
                 waitSeconds(2.25),
                indexer.IndexForwardForTime(0.5)
            )
        );


        //run intake
        buttonBoard.button(1).whileTrue(intake.intakeIn());
        //run outake
        buttonBoard.button(2).whileTrue(intake.intakeOut());
        //toggle rev shooter
        buttonBoard.button(3).toggleOnTrue(shooter.rev(0.8));
        //index in
        buttonBoard.button(4).whileTrue(indexer.IndexerForward());
        //index out
        buttonBoard.button(5).whileTrue(indexer.IndexerBackward());
        //shoot
        buttonBoard.button(6).onTrue(shoot);
        
        
    }
}
  