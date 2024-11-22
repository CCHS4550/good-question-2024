package frc.ControlScheme;
import javax.naming.ldap.Control;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.helpers.ControlScheme;
import frc.robot.subsystems.Drivetrain;
public class driveScheme implements ControlScheme{
    private static CommandXboxController controller;

    public static void configure(Drivetrain driveTrain, int port){
        controller = new CommandXboxController(port);
        SlewRateLimiter xLimit = new SlewRateLimiter(0.5);
        SlewRateLimiter yLimit = new SlewRateLimiter(0.5);
        driveTrain.setDefaultCommand(
            new RunCommand(()-> driveTrain.teleDrive(xLimit.calculate(-controller.getLeftX()), -controller.getRightY())));
    }
}