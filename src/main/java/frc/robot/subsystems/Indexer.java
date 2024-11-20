package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.helpers.CCSparkMax;
import frc.maps.Constants;

public class Indexer extends SubsystemBase{
    private CCSparkMax indexerMotor = new CCSparkMax("indexMotor", "im", Constants.MotorConstants.INDEXER, MotorType.kBrushless,
            IdleMode.kBrake, Constants.MotorConstants.INDEXER_REVERSED);
    }
    //methods
    public void setIndexerMotorForward() {
            indexerMotor.set(0.6);
    }
    public void setIndexerMotorReverse() {
            indexerMotor.set(-0.6);
    }
    //commands
    public Command IndexerForward(){
        return this.run(() -> setIndexerMotorForward()); 
    }
    public Command IndexerBackward(){
        return this.run(() -> setIndexerMotorReverse()); 
    }



