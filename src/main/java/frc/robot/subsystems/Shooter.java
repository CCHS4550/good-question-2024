package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;

public class Shooter extends SubsystemBase{
    CCSparkMax lowerShooter = new CCSparkMax("lowerShooter", "ls", 0, MotorType.kBrushless, IdleMode.kCoast, false);
    CCSparkMax upperShooter = new CCSparkMax("upperShooter", "us", 0, MotorType.kBrushless, IdleMode.kCoast, true);
    
    private SlewRateLimiter shooterSlewRateLimiterOne = new SlewRateLimiter(1,-1,0);
    private SlewRateLimiter shooterSlewRateLimiterTwo = new SlewRateLimiter(1,-1,0);

    public void setShooterSpeed(double speed){
        lowerShooter.set(shooterSlewRateLimiterOne.calculate(speed));
        upperShooter.set(shooterSlewRateLimiterTwo.calculate(speed));
    }

    public Command rev(double speed){
        return this.run(() -> setShooterSpeed(speed));
    }
    public Command revForTime(double speed, double time){
        return this.run(() -> setShooterSpeed(speed)).withTimeout(time);
    }

    public Command halt(){
        return Commands.runOnce(()-> {}, this);
    }
}
