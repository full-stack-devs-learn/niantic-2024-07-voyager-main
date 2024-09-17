package com.niantic;

import com.niantic.services.LogFileService;
import com.niantic.services.LogService;

public class LogDemo
{
    public static void main(String[] args)
    {
        LogService logService = new LogFileService("errors");

        logService.logMessage("test");
        logService.logMessage("another");
    }
}
