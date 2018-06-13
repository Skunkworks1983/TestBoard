package frc.team1983.subsystems.sensors;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;

public class NavX extends AHRS
{
    public NavX()
    {
        super(I2C.Port.kOnboard);
    }
}
