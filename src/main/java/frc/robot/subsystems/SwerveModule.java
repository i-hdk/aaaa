package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.ctre.phoenix.sensors.WPI_CANCoder;

import frc.robot.Constants;

public class SwerveModule{
    private WPI_TalonFX mRotor, mThrottle; //the rotor being the motor that rotates the entire wheel module, and throttle being the motor which turns the wheel
    private WPI_CANCoder mRotorEncoder; //absolute encoder that tracks the absolute angle of the wheel module
    /**
     * 
     * @param rotorID CAN ID of the rotor motor
     * @param throttleID CAN ID of the throttle motor
     * @param CANCoderID CAN ID of the CANCoder 
     * @param throttleReversed checks if the throttle motor is reversed or not
     * @param rotorOffsetAngle
     */
    public SwerveModule(int rotorID, int throttleID, int CANCoderID, boolean throttleReversed, double rotorOffsetAngle)
    {
        mRotor = new WPI_TalonFX(rotorID);
        mThrottle = new WPI_TalonFX(throttleID);
        mRotorEncoder = new WPI_CANCoder(CANCoderID);
        mThrottle.setInverted(throttleReversed);

        mRotor.configFactoryDefault();
        mThrottle.configFactoryDefault();
        mRotorEncoder.configFactoryDefault();

        mRotorEncoder.configAbsoluteSensorRange(AbsoluteSensorRange.Signed_PlusMinus180);	
        mRotorEncoder.configSensorDirection(false);
        mRotorEncoder.configSensorInitializationStrategy(SensorInitializationStrategy.BootToAbsolutePosition);

        mRotor.configVoltageCompSaturation(Constants.kVoltageCompensation);
        mRotor.enableVoltageCompensation(true);
        mThrottle.configVoltageCompSaturation(Constants.kVoltageCompensation);
        mThrottle.enableVoltageCompensation(true);

        mRotor.setInverted(TalonFXInvertType.Clockwise); 
        mRotor.setNeutralMode(NeutralMode.Brake);
        mThrottle.setNeutralMode(NeutralMode.Brake);
    }

/**
 * Manually jogs rotor motor
 * @param percent speed [-1,1]
 */
    public void jogRotor(double percent){

    }
}