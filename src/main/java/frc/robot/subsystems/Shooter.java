package frc.robot.subsystems;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;

public class Shooter extends SubsystemBase{
    CCSparkMax lowerShooter = new CCSparkMax("lowerShooter", "ls", int deviceID, MotorType.kBrushless, IdleMode.kCoast, false);
    CCSparkMax upperShooter = new CCSparkMax("upperShooter", "us", int deviceID, MotorType.kBrushless, IdleMode.kCoast, true);
    
    private SlewRateLimiter shooterSlewRateLimiter = new SlewRateLimiter(1,-1,0);

    public void setShooterSpeed(double speed){
        lowerShooter.set(shooterSlewRateLimiter.calculate(speed));
        upperShooter.set(shooterSlewRateLimiter.calculate(speed));
    }

    public Command shoot(double speed){
        return this.runOnce(() -> setShooterSpeed(speed));
    }

    public Command halt(){
        return Commands.runOnce(()-> {}, this);
    }
}
