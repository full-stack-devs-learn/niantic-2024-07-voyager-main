package com.niantic.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFileService implements LogService
{
    private String directory;

    public LogFileService(String directory)
    {
        this.directory = directory;

        File dir = new File(directory);
        if(! dir.exists()) dir.mkdir();
    }

    private String getFileName()
    {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return formatter.format(date) + ".log";
    }

    private String getFilePath()
    {
        return directory + "/" + getFileName();
    }

    @Override
    public void logMessage(String message)
    {

        File file = new File(getFilePath());
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");


        try(FileOutputStream stream = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(stream))
        {
            writer.printf("%s %s\n", date.format(formatter), message);
        }
        catch (IOException e)
        {
            // swallow
        }

    }
}
