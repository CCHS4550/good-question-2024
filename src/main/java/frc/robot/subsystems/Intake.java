package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;
import frc.robot.Constants;

public class Intake extends SubsystemBase{
    CCSparkMax intakeTop = new CCSparkMax("Intake Top", "IT", Constants.OperatorConstants.IntakeTopID, MotorType.kBrushless, IdleMode.kCoast, false);
    CCSparkMax intakeBottom = new CCSparkMax("Intake Motor", "IB", Constants.OperatorConstants.IntakeBottomID, MotorType.kBrushless, IdleMode.kCoast, true);

    SlewRateLimiter oneLimit = new SlewRateLimiter(0.2,-1,0);
    SlewRateLimiter twoLimit = new SlewRateLimiter(0.2,-1,0);
    public void motorIn(){
    intakeTop.set(oneLimit.calculate(0.3));
    intakeBottom.set(twoLimit.calculate(0.15));
}
public void motorOut(){
    intakeTop.set(oneLimit.calculate(-0.2));
    intakeBottom.set(twoLimit.calculate(-0.2));
}
public void motorStop(){
     intakeTop.set(0);
    intakeBottom.set(0);
}
public Command intakeIn(){
    return new RunCommand(() ->
    {motorIn();} , this);
}
public Command intakeOut(){
    return new RunCommand(() ->
    {motorOut();} , this);
}
public Command intakeStop(){
    return this.run(()-> motorStop());
}
}

