package com.niantic;

import java.util.Timer;
import java.util.TimerTask;

public class Bow
{
    private int arrowCount = 10;
    Timer timer = new Timer();

    public Bow()
    {
        timer.schedule(new TimerTask(){
            @Override
            public void run()
            {
                if(arrowCount < 10) arrowCount++;
            }
        }, 0, 5000);
    }

    public void attack()
    {
        arrowCount--;


    }


}
