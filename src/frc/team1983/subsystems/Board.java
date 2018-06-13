/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team1983.subsystems;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team1983.settings.Constants;
import frc.team1983.subsystems.sensors.NavX;
import frc.team1983.subsystems.sensors.PSoC;

public class Board extends Subsystem
{
    public Motor motor1, motor2;
    private NavX navX;
    private PSoC pSoC;

    public void initDefaultCommand()
    {
        motor1 = new Motor(Constants.MOTOR1_PORT, false, true);
        motor2 = new Motor(Constants.MOTOR2_PORT, false, true);
        navX = new NavX();

        pSoC = new PSoC(SPI.Port.kOnboardCS0);
    }

    public void setMotor1(double value)
    {
        motor1.set(value);
    }

    public void setMotor2(double value)
    {
        motor2.set(value);
    }

    public void setMotors(double value1, double value2)
    {
        setMotor1(value1);
        setMotor2(value2);
    }

    public double getMotor1Rotation()
    {
        return motor1.getSelectedSensorPosition(0)/* / Constants.ENCODER_RESOLUTION*/;
    }

    public double getMotor2Rotation()
    {
        return motor2.getSelectedSensorPosition(0)/* / Constants.ENCODER_RESOLUTION*/;
    }

    public void resetEncoders()
    {
        motor1.resetEncoderValue();
        motor2.resetEncoderValue();
    }

    public double getAngle()
    {
        return navX.getAngle();
    }

    public void sendMessage()
    {
        pSoC.sendMessage();
    }
}
