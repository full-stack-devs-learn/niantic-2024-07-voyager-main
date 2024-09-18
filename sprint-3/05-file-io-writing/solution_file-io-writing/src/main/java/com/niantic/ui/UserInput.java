package com.niantic.ui;

import com.niantic.models.Assignment;
import com.niantic.models.AssignmentStatistics;
import com.niantic.models.GradeStatistics;

import java.util.List;

public class UserInput extends Console
{
    public static int homeScreenSelection()
    {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("-".repeat(30));
        System.out.println();
        System.out.println("  1) Display files");
        System.out.println();
        System.out.println("  ------------ Individual File ------------");
        System.out.println("  2) Student: display all scores");
        System.out.println("  3) Student: display student statistics");
//        System.out.println("  4) Student: create student report");
        System.out.println();
        System.out.println("  ---------- Challenge All Files ----------");
        System.out.println("  5) All Students: display all student statistics");
//        System.out.println("  6) All Student: create all students report");
        System.out.println("  7) All Assignments: display assignments statistics summary");
        System.out.println("  8) All Assignments: display assignments statistics details");
        System.out.println();
        System.out.println("  0) Exit");

        System.out.println();
        System.out.print("Please make a selection: ");

        return Integer.parseInt(in.nextLine());
    }

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }

    public static void displayFileNames(String[] files)
    {
        System.out.println();
        System.out.println("Students:");
        System.out.println("-".repeat(30));
        for (int i = 0; i < files.length; i++)
        {
            var file = files[i];
            System.out.println((i + 1) + ") " + file);
        }
    }

    public static void displayScores(String studentName, List<Assignment> assignments)
    {
        System.out.println();
        System.out.println("Assignments: " + studentName);
        System.out.println("-".repeat(30));
        assignments.forEach(assignment -> System.out.println(assignment));
    }

    public static void displayMax(String studentName, double average)
    {
        System.out.println();
        System.out.printf("%s highest score is %.2f\n", studentName, average);
    }

    public static void displayMin(String studentName, double average)
    {
        System.out.println();
        System.out.printf("%s lowest score is %.2f\n", studentName, average);
    }

    public static void displayStatistics(GradeStatistics statistics, boolean showCounts)
    {
        int length = showCounts ? 60 : 40;
        System.out.println();
        System.out.println(statistics.getName());
        System.out.println("-".repeat(length));
        if(showCounts)
        {
            System.out.printf("%-54s %d\n", "Total Students", statistics.getNumberOfStudents());
            System.out.printf("%-54s %d\n", "Total Assignments", statistics.getNumberOfAssignments());
        }

        displayStatistic("Low Score", statistics.getLowScore(), statistics.getLowAssignments(), showCounts);
        displayStatistic("High Score", statistics.getHighScore(), statistics.getHighAssignments(), showCounts);
        displayStatistic("Average Score", statistics.getAverageScore(), statistics.getAverageAssignments(), showCounts);
    }

    public static void displayStatistic(String statisticName, int  value, List<Assignment> assignments, boolean showCounts)
    {
        int length = showCounts ? 60 : 40;
        System.out.println();

        System.out.println("-".repeat(length));
        if(showCounts)
        {
            System.out.printf("%-55s %d\n", statisticName, value);
        }
        else
        {
            System.out.printf("%-34s %d\n", statisticName, value);
        }
        System.out.println("-".repeat(length));

        assignments.forEach(assignment -> {
            if(showCounts)
            {
                System.out.printf("%-3d %-30s %-20s %-5d\n", assignment.getNumber(), assignment.getAssignmentName(), assignment.getFirstName() + " " + assignment.getLastName(), assignment.getScore());
            }
            else {
                System.out.printf("%-3d %-30s %-5d\n", assignment.getNumber(), assignment.getAssignmentName(), assignment.getScore());
            }
        });
    }

    public static void displayAssignmentStatisticsSummary(AssignmentStatistics statistics)
    {
        System.out.println();
        System.out.println("Assignment Statistics");
        System.out.println("-".repeat(60));

        System.out.printf("%-35s %-5s %-5s %-5s\n", "Assignment", "Low", "High", "Avg");
        System.out.printf("%-35s %-5s %-5s %-5s\n", "-".repeat(35), "-".repeat(5), "-".repeat(5), "-".repeat(5));
        statistics.getAssignmentsNames().forEach(assignmentName -> {
            var stat = statistics.getStatistics(assignmentName);
            System.out.printf("%-35s %-5d %-5d %-5d\n", assignmentName, stat.getLowScore(), stat.getHighScore(), stat.getAverageScore());
        });

        waitForUser();
    }

    public static void displayAssignmentStatisticsDetails(AssignmentStatistics statistics)
    {
        System.out.println();
        System.out.println("Assignment Statistics");
        System.out.println("-".repeat(60));

        statistics.getAssignmentsNames().forEach(assignmentName -> {
            System.out.println();
            System.out.println("*".repeat(60));
            System.out.println(assignmentName.toUpperCase());
            System.out.println("*".repeat(60));

            displayStatistics(statistics.getStatistics(assignmentName), true);
            waitForUser();
        });
    }
}
