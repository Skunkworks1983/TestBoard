package frc.team1983.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import frc.team1983.settings.Constants;

public class Motor extends TalonSRX
{
    private boolean reversed;
    private int encoderType;
    private Encoder encoder;
    private double encoderResolution = 1;

    public Motor(int deviceNumber)
    {
        super(deviceNumber);
        setInverted(false);
        this.reversed = false;
        this.encoderType = Constants.EncoderType.NONE;
    }

    public Motor(int deviceNumber, boolean reversed, int encoderType, double encoderResolution)
    {
        super(deviceNumber);
        setInverted(reversed);
        this.reversed = reversed;
        this.encoderType = encoderType;
        this.encoderResolution = encoderResolution;

        if(encoderType == Constants.EncoderType.TALON)
        {
            configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
            setSelectedSensorPosition(0, 0, 10);
        }
    }

    public Motor(int deviceNumber, boolean reversed, double encoderResolution, int encoderPort1, int encoderPort2)
    {
        super(deviceNumber);
        setInverted(reversed);
        this.reversed = reversed;
        this.encoderType = Constants.EncoderType.DIO;
        this.encoderResolution = encoderResolution;
        this.encoder = new Encoder(encoderPort1, encoderPort2);
    }

    public void set(double value)
    {
        set(ControlMode.PercentOutput, value);
    }

    public double getRotations()
    {
        if(encoderType == Constants.EncoderType.TALON)
        {
            return getSelectedSensorPosition(0) / this.encoderResolution;
        }
        else if(encoderType == Constants.EncoderType.DIO)
        {
            return -encoder.getDistance() / this.encoderResolution;
        }

        return -1;
    }

    public void resetEncoderValue()
    {
        if(encoderType == Constants.EncoderType.TALON)
        {
            setSelectedSensorPosition(0, 0, 0);
        }
        else if(encoderType == Constants.EncoderType.DIO)
        {
            encoder.reset();
        }
    }

    public boolean getReversed()
    {
        return reversed;
    }
}
