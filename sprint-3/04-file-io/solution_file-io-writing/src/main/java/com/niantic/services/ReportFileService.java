package com.niantic.services;

import com.niantic.models.Assignment;
import com.niantic.models.GradeStatistics;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

public class ReportFileService implements ReportService
{

    @Override
    public void createReport(GradeStatistics statistics, boolean showCounts)
    {
        LocalDate today = LocalDate.now();
        File file = new File("reports/" + today.toString() + "_" + statistics.getName().replace(" ","_") + ".txt");

        try(PrintWriter pw = new PrintWriter(file))
        {
            int length = showCounts ? 60 : 40;
            pw.println();
            pw.println(statistics.getName());
            pw.println("-".repeat(length));
            if (showCounts)
            {
                pw.printf("%-54s %d\n", "Total Students", statistics.getNumberOfStudents());
                pw.printf("%-54s %d\n", "Total Assignments", statistics.getNumberOfAssignments());
            }

            displayStatistic(pw,"Low Score", statistics.getLowScore(), statistics.getLowAssignments(), showCounts);
            displayStatistic(pw,"High Score", statistics.getHighScore(), statistics.getHighAssignments(), showCounts);
            displayStatistic(pw,"Average Score", statistics.getAverageScore(), statistics.getAverageAssignments(), showCounts);
        }
        catch(IOException e)
        {
            
        }
    }

    public void displayStatistic(PrintWriter pw, String statisticName, int  value, List<Assignment> assignments, boolean showCounts)
    {
        int length = showCounts ? 60 : 40;
        pw.println();

        pw.println("-".repeat(length));
        if(showCounts)
        {
            pw.printf("%-55s %d\n", statisticName, value);
        }
        else
        {
            pw.printf("%-34s %d\n", statisticName, value);
        }
        pw.println("-".repeat(length));

        assignments.forEach(assignment -> {
            if(showCounts)
            {
                pw.printf("%-3d %-30s %-20s %-5d\n", assignment.getNumber(), assignment.getAssignmentName(), assignment.getFirstName() + " " + assignment.getLastName(), assignment.getScore());
            }
            else {
                pw.printf("%-3d %-30s %-5d\n", assignment.getNumber(), assignment.getAssignmentName(), assignment.getScore());
            }
        });
    }
    
}
