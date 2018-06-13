/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team1983.settings;

/**
 * The Constants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants
{
    public static final int MOTOR1_PORT = 0;
    public static final int MOTOR2_PORT = 1;

    public static final int MOTOR2_ENCODER_PORT1 = 0;
    public static final int MOTOR2_ENCODER_PORT2 = 1;

    public static final double MOTOR1_ENCODER_RESOLUTION = 140.0;
    public static final double MOTOR2_ENCODER_RESOLUTION = 280.0;

    public static class EncoderType
    {
        public static final int NONE = -1;
        public static final int TALON = 0;
        public static final int DIO = 1;
    }
}
