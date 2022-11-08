package frc.robot;

public class PIDController {

    private double kP, kI, kD, prevError;


    public PIDController (double kP, double kI, double kD){
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        prevError = 0;
    }

    public double out(double sensorVal, double desiredVal){
        double error = desiredVal - sensorVal;
        double derivative = error - prevError;
        prevError = error;
        double power = error*kP+derivative*kD;
        return power;
    }
}