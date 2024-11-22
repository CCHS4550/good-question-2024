package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;

public class Intake extends SubsystemBase{
    CCSparkMax intakeMotor = new CCSparkMax("Intake Motor", "IM", 1, MotorType.kBrushless, IdleMode.kBrake, false);
    CCSparkMax outtakeMotor = new CCSparkMax("Outtake Motor", "OM", 2, MotorType.kBrushless, IdleMode.kBrake, true);
    public void motorIn(){
    intakeMotor.set(0.5);
}
public void motorOut(){
    outtakeMotor.set(-0.5);
}
public Command intakeIn(){
    return new RunCommand(() ->
    {motorIn();} , this);
}
public Command intakeOut(){
    return new RunCommand(() ->
    {motorOut();} , this);
}
}

