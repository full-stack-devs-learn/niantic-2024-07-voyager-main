package com.niantic;

import java.util.Timer;
import java.util.TimerTask;

public class Bow
{

    private String name;
    private int maxQuiverSize;
    private int arrowCount;
    private String arrowType;
    private final int damage;
    private int percentCharged = 0;
    private boolean isPowered = false;

    public Bow(String name, int quiverSize, String arrowType, int damage)
    {
        this.name = name;
        this.maxQuiverSize = quiverSize;
        this.arrowCount = quiverSize;
        this.arrowType = arrowType;
        this.damage = (arrowType.equalsIgnoreCase("explosive"))
                        ? damage * 3
                        : (arrowType.equalsIgnoreCase("poison"))
                            ? damage * 2
                            : damage;

        scheduleCharge();


    }

    private void scheduleCharge()
    {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                if(percentCharged < 100)
                {
                    percentCharged += 20;
                }
            }
        }, 1000, 1000);
    }

    public int getPercentCharged()
    {
        return percentCharged;
    }

    public String getName()
    {
        return name;
    }

    public int getMaxQuiverSize()
    {
        return maxQuiverSize;
    }

    public int getArrowCount()
    {
        return arrowCount;
    }

    public String getArrowType()
    {
        return arrowType;
    }

    public int getDamage()
    {
        return damage;
    }

    public int attack()
    {

        if(!isPowered)
        {
            arrowCount--;

            Timer timer = new Timer();
            timer.schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    if (arrowCount < maxQuiverSize)
                    {
                        arrowCount++;
                    }
                }
            }, 5000);

            return damage;
        }
        else
        {
            return damage * 2;
        }
    }

    public int powerAttack()
    {
        if(percentCharged == 100)
        {
            isPowered = true;
            percentCharged = 0;

            Timer timer = new Timer();
            timer.schedule(new TimerTask()
            {
                @Override
                public void run()
                {
                    isPowered = false;
                }
            }, 5000);
        }

        return 0;
    }


}
