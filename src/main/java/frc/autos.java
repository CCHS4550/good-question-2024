package frc;

import static edu.wpi.first.wpilibj2.command.Commands.parallel;
import static edu.wpi.first.wpilibj2.command.Commands.sequence;
import static edu.wpi.first.wpilibj2.command.Commands.waitSeconds;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

 public class autos {
//     public static Command forwardShoot(){
//         Command forwardShooter = sequence(null)
//         return
//     }
    public static Command moveForward(Drivetrain drivetrain){
        return drivetrain.autoDriveForward(0.2,6.5);
    }
    public static Command moveForwardandShoot(Drivetrain drivetrain, Shooter shooter, Indexer indexer){
    return sequence( drivetrain.autoDriveForward(0.1,2),drivetrain.autoDriveForward(0.2,4), parallel(shooter.revForTime(0.5, 5.0), 
        sequence(
            waitSeconds(1.75), 
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55),
            indexer.revForTime(0.3, 0.25),
            waitSeconds(0.55)
            )));
    }
 }
