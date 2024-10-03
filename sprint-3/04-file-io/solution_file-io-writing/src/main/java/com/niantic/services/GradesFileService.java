package com.niantic.services;

import com.niantic.models.Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GradesFileService implements GradesService
{

    @Override
    public String[] getFileNames()
    {
        File directory = new File("files");
        var fileNames = Arrays.stream(directory.list()).filter(file -> file.endsWith(".csv")).sorted().toArray(String[]::new);
        return fileNames;
    }

    @Override
    public List<Assignment> getAssignments(String fileName)
    {
        List<Assignment> assignments = new ArrayList<>();

        File file = new File("files/" + fileName);

        try(Scanner scanner = new Scanner(file))
        {
            // skip line 1
            scanner.nextLine();
            while (scanner.hasNextLine())
            {
                var line = scanner.nextLine();
                var columns = line.split(",");

                int number = Integer.parseInt(columns[0]);
                String firstName = columns[1];
                String lastName = columns[2];
                String name = columns[3];
                int grade = Integer.parseInt(columns[4]);

                assignments.add(new Assignment(number, firstName, lastName, name, grade));
            }
        }
        catch (FileNotFoundException e)
        {
            // swallow exception
        }

        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames)
    {
        List<Assignment> allAssignments = new ArrayList<>();

        for(var fileName : fileNames)
        {
            var assignments = getAssignments(fileName);
            allAssignments.addAll(assignments);
        }

        return allAssignments;
    }
}
