package com.niantic;

import static java.io.IO.println;

public class MyApplication implements Runnable
{
    @Override
    public void run()
    {
        println("The application is running");
    }
}
