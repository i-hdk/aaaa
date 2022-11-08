package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.ctre.phoenix.sensors.WPI_CANCoder;

import frc.robot.Constants;

public class SwerveModule{
    private WPI_TalonFX mRotor, mThrottle;
    private WPI_CANCoder mRotorEncoder;

    public SwerveModule(int rotorID, int throttleID, int CANCoderID, boolean throttleReversed, double rotorOffsetAngle){
        mRotor = new WPI_TalonFX(rotorID);
        mThrottle = new WPI_TalonFX(throttleID);
        mThrottle.setInverted(throttleReversed);
        mRotorEncoder = new WPI_CANCoder(CANCoderID);
        mRotor.configFactoryDefault();
        mThrottle.configFactoryDefault();
        mRotorEncoder.configFactoryDefault();
        mRotorEncoder.configAbsoluteSensorRange(AbsoluteSensorRange.Signed_PlusMinus180);	
        mRotorEncoder.configSensorDirection(false);
        mRotorEncoder.configSensorInitializationStrategy(SensorInitializationStrategy.BootToAbsolutePosition);
        mRotor.setInverted(TalonFXInvertType.Clockwise); 
        mRotor.configVoltageCompSaturation(Constants.kVoltageCompensation);
        mThrottle.configVoltageCompSaturation(Constants.kVoltageCompensation);
        mRotor.enableVoltageCompensation(true);
        mThrottle.enableVoltageCompensation(true);
        mRotor.setNeutralMode(NeutralMode.Brake);
        mThrottle.setNeutralMode(NeutralMode.Brake);
    }
}