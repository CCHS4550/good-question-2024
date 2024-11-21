public class Drivetrain extends SubsystemBase{
    private CCSparkMax frontLeft = new CCSparkMax("frontLeft", "FL", 0, MotorType.kBrushless, IdleMode.kBrake, false);
    private CCSparkMax frontRight = new CCSparkMax("frontRight", "FR", 0, MotorType.kBrushless, IdleMode.kBrake, false);
    private CCSparkMax backLeft = new CCSparkMax("backLeft", "BL", 0, MotorType.kBrushless, IdleMode.kBrake, false);
    private CCSparkMax backRight = new CCSparkMax("backRight", "BR", 0, MotorType.kBrushless, IdleMode.kBrake, false);

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    DifferentialDrive diffDrive = new DifferentialDrive(frontLeft, frontRight);
    public void teleDrive(double moveSpeed, double turnSpeed){
        diffDrive.arcadeDrive(moveSpeed, turnSpeed);
    }
   
    public void driveStraight(double speed){
        frontLeft.set(speed);
        frontRight.set(speed);
    }
    public void turnDirection(boolean direction, double speed){
        if (direction == true) {
            frontLeft.set(speed * -1);
            frontRight.set(speed);
        }
        else {
            frontLeft.set(speed);
            frontRight.set(speed * -1);
        }
    }
    
    public command basicDrive (double speed){
        return this.run(()-> driveStright(speed));
    }
    public command basicTurn (boolean direction, double speed){
        return this.run(()-> turnDirection(direction, speed));
    }
    public command controlledDrive(double movespeed, double turnSpeed){
        return this.run(()-> teleDrive(movespeed, turnSpeed));
    }

}