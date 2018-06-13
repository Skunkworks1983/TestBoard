package frc.team1983.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Motor extends TalonSRX
{
    private boolean reversed;

    public Motor(int deviceNumber)
    {
        super(deviceNumber);
        setInverted(false);
        this.reversed = false;
    }

    public Motor(int deviceNumber, boolean reversed)
    {
        super(deviceNumber);
        setInverted(reversed);
        this.reversed = reversed;
    }
    
    public Motor(int deviceNumber, boolean reversed, boolean hasEncoder)
    {
        super(deviceNumber);
        setInverted(reversed);
        this.reversed = reversed;

        if(hasEncoder)
        {
            configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
            setSelectedSensorPosition(0, 0, 10);
        }
    }

    public void set(double value)
    {
        set(ControlMode.PercentOutput, value);
    }

    public double getEncoderValue()
    {
        return getSelectedSensorPosition(0);
    }

    public void resetEncoderValue()
    {
        setSelectedSensorPosition(0, 0, 0);
    }

    public boolean getReversed()
    {
        return reversed;
    }
}
