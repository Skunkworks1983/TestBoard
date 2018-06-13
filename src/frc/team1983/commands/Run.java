package frc.team1983.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team1983.Robot;

public class Run extends Command
{
    public Run()
    {
        requires(Robot.board);
    }

    protected void initialize()
    {
        Robot.board.resetEncoders();
    }

    protected void execute()
    {
        Robot.board.setMotors(0.1, 0.0);
        System.out.println("1: " + Robot.board.getMotor1Rotation() + ", 2: " + Robot.board.getMotor2Rotation());
        //System.out.println("NavX: " + Robot.board.getAngle());
        Robot.board.sendMessage();
    }

    protected boolean isFinished()
    {
        return isTimedOut();
    }

    protected void interrupted()
    {
        end();
    }

    protected void end()
    {
        Robot.board.setMotors(0, 0);
    }
}
