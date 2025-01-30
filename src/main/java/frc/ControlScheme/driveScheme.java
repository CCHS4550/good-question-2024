package frc.ControlScheme;
import static edu.wpi.first.wpilibj2.command.Commands.runOnce;

import java.util.function.DoubleSupplier;

import javax.naming.ldap.Control;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.helpers.ControlScheme;
import frc.robot.subsystems.Drivetrain;
public class driveScheme implements ControlScheme{
    private static DoubleSupplier driveSpeeb = ()-> 1.0;
    private static CommandXboxController controller;
    public static void configure(Drivetrain driveTrain, int port){
        controller = new CommandXboxController(port);
        // SlewRateLimiter xLimit = new SlewRateLimiter(0.5);
        // SlewRateLimiter yLimit = new SlewRateLimiter(0.5);

        driveTrain.setDefaultCommand(
            new RunCommand(()-> driveTrain.teleDrive(-controller.getRightX()*driveSpeeb.getAsDouble(), -controller.getLeftY()*driveSpeeb.getAsDouble()), driveTrain));
        controller.rightTrigger().onFalse(runOnce(()->setSlow()));
        controller.rightTrigger().onTrue(runOnce(()->setFast()));      
        }
    private static void setFast(){
        driveSpeeb = ()-> 0.6;
    }
    private static void setSlow(){
        driveSpeeb = ()-> 1.0;
    }
}