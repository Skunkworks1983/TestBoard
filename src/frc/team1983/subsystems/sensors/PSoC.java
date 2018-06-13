package frc.team1983.subsystems.sensors;

import edu.wpi.first.wpilibj.SPI;

public class PSoC
{
    private SPI spi;

    public PSoC(SPI.Port port)
    {
        this.spi = new SPI(port);
        spi.initAuto(10);
        spi.setClockRate(1000000);
        spi.setChipSelectActiveLow();
    }

    public void sendMessage()
    {
        byte[] bytes = new byte[]{0x01, 0x01, 0x17};

        if(spi == null)
        {
            System.out.println("Port not found!");
            return;
        }

        spi.write(bytes, bytes.length);
    }
}
