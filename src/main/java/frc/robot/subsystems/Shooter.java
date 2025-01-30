package frc.robot.subsystems;

import static edu.wpi.first.wpilibj2.command.Commands.deadline;
import static edu.wpi.first.wpilibj2.command.Commands.waitSeconds;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{
    CCSparkMax lowerShooter = new CCSparkMax("lowerShooter", "ls", Constants.OperatorConstants.ShooterOneID, MotorType.kBrushless, IdleMode.kCoast, true);
    CCSparkMax upperShooter = new CCSparkMax("upperShooter", "us", Constants.OperatorConstants.ShooterTwoID, MotorType.kBrushless, IdleMode.kCoast, false);
    
    private SlewRateLimiter shooterSlewRateLimiterOne = new SlewRateLimiter(1,-1,0);
    private SlewRateLimiter shooterSlewRateLimiterTwo = new SlewRateLimiter(1,-1,0);

    public void setShooterSpeed(double speed){
        lowerShooter.set(shooterSlewRateLimiterOne.calculate(speed));
        upperShooter.set(shooterSlewRateLimiterTwo.calculate(speed));
    }
    public void setShortSpeed(){
        lowerShooter.set(shooterSlewRateLimiterOne.calculate(0.2));
        upperShooter.set(shooterSlewRateLimiterTwo.calculate(0.3));
    }
    public Command rev(double speed){
        return this.runEnd(() -> setShooterSpeed(speed), () -> setShooterSpeed(0));
    }
    public Command revForTime(double speed, double time){
        return deadline(waitSeconds(time), rev(0.6)).withTimeout(time);
    }
    public Command revForTimeShort(double speed, double time){
        return deadline(waitSeconds(time), shortRev()).withTimeout(time);
    }
    public Command shortRev(){
        return this.runEnd(()->setShortSpeed(), (()->setShooterSpeed(0)));
    }
    public Command halt(){
        return Commands.runOnce(()-> {}, this);
    }
}
