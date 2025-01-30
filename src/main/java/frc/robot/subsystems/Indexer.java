package frc.robot.subsystems;

import static edu.wpi.first.wpilibj2.command.Commands.deadline;
import static edu.wpi.first.wpilibj2.command.Commands.waitSeconds;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;
import frc.robot.Constants;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;
import frc.robot.Constants;

public class Indexer extends SubsystemBase{
    private CCSparkMax indexerMotor = new CCSparkMax("indexMotor", "im", Constants.OperatorConstants.IMdeviceID, MotorType.kBrushless,
            IdleMode.kBrake, false);
    //methods
    public void setIndexerMotorForward() {
            indexerMotor.set(0.3);
    }
    public void setIndexerMotorReverse() {
            indexerMotor.set(-0.3);
    }
    public void IndexerStop(){
        indexerMotor.set(0.0);
    }
    //commands
    public Command IndexerForward(){
        return this.runEnd(() -> setIndexerMotorForward(), ()-> IndexerStop()); 
    }
    public Command IndexerBackward(){
        return this.runEnd(() -> setIndexerMotorReverse(), ()-> IndexerStop()); 
    }
    public Command IndexStopper(){
        return this.run(() -> IndexerStop());
    }
    public Command revForTime(double speed, double time){
        return deadline(waitSeconds(time), IndexerForward()).withTimeout(time);
    }
        }




