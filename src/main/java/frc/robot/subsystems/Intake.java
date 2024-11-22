package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;

public class Intake extends SubsystemBase{
    CCSparkMax intakeTop = new CCSparkMax("Intake Top", "IT", Constants.OperatorConstants.IntakeTopID, MotorType.kBrushless, IdleMode.kBrake, false);
    CCSparkMax intakeBottom = new CCSparkMax("Intake Motor", "IB", Constants.OperatorConstants.IntakeBottomID, MotorType.kBrushless, IdleMode.kBrake, true);

    public void motorIn(){
    intakeTop.set(0.5);
    intakeBottom.set(0.5);
}
public void motorOut(){
    intakeTop.set(-0.5);
    intakeBottom.set(-0.5)
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

