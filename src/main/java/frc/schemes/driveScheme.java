public class driveScheme implements ControlScheme{
    private static CommandXboxController controller;

    public static void configure(DriveTrain driveTrain, int port){
        controller = new CommandXboxController(port);
        SlewRateLimiter xLimit = new SlewRateLimiter(0.5);
        SlewRateLimiter yLimit = new SlewRateLimiter(0.5);
        driveTrain.setDefaultCommand(
            DriveTrain.controlledDrive(
                xLimit.calculate(-controller.getLeftY()),
                yLimit.calculate(-controller.getRightX())
            )
        )
    }
}