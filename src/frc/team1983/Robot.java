package frc.team1983;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team1983.commands.Run;
import frc.team1983.subsystems.Board;

public class Robot extends TimedRobot 
{

    public static final Board board = new Board();

    @Override
    public void robotInit() 
    {

    }

    @Override
    public void disabledInit() 
    {
        
    }

    @Override
    public void disabledPeriodic() 
    {
        Scheduler.getInstance().run();
    }


    @Override
    public void autonomousInit() 
    {

    }

    @Override
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    TalonSRX test;

    @Override
    public void teleopInit() 
    {
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().add(new Run());
    }

    @Override
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic()
    {

    }
}
