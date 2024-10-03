package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.AssignmentStatistics;
import com.niantic.models.GradeStatistics;
import com.niantic.services.*;
import com.niantic.ui.UserInput;

import java.util.List;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();
    private ReportService reportService = new ReportFileService();
    private GradeStatisticsService gradeStatisticsService = new GradeStatisticsService();

    public void run()
    {
        while(true)
        {
            int choice = UserInput.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    displayFileScores();
                    break;
                case 3:
                    displayStudentStatistics();
                    break;
                case 4:
                    createStudentScoreReport();
                    break;
                case 5:
                    displayAllStudentsStatistics();
                    break;
                case 6:
                    createAllStudentsReport();
                    break;
                case 7:
                    displayAllAssignmentStatistics();
                    break;
                case 8:
                    displayAllAssignmentStatisticsDetails();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    // menu option methods
    private void displayAllFiles()
    {
        var files = gradesService.getFileNames();
        UserInput.displayFileNames(files);
        UserInput.waitForUser();
    }

    private void displayFileScores()
    {
        var fileName = getFileName();
        var assignments = gradesService.getAssignments(fileName);

        var studentName = parseStudentName(fileName);
        UserInput.displayScores(studentName, assignments);
        UserInput.waitForUser();
    }

    private void displayStudentStatistics()
    {
        var statistics = createFileStatistics();

        UserInput.displayStatistics(statistics, false);
        UserInput.waitForUser();

    }

    private void createStudentScoreReport()
    {
        var statistics = createFileStatistics();

        reportService.createReport(statistics, false);
        UserInput.displayMessage("Report has been created for " + statistics.getName());
        UserInput.waitForUser();

    }

    private void displayAllStudentsStatistics()
    {
        var statistics = createAllStudentsStatistics();

        UserInput.displayStatistics(statistics, true);
        UserInput.waitForUser();
    }

    private void createAllStudentsReport()
    {
        var statistics = createAllStudentsStatistics();

        reportService.createReport(statistics, true);

        UserInput.displayMessage("All students report has been created.");
        UserInput.waitForUser();
    }

    private void displayAllAssignmentStatistics()
    {
        var assignments = getAllAssignments();
        var stats = new AssignmentStatistics(assignments);

        UserInput.displayAssignmentStatisticsSummary(stats);
    }

    private void displayAllAssignmentStatisticsDetails()
    {
        var assignments = getAllAssignments();
        var stats = new AssignmentStatistics(assignments);

        UserInput.displayAssignmentStatisticsDetails(stats);

    }

    // helpers
    private String getFileName()
    {
        var files = gradesService.getFileNames();
        UserInput.displayFileNames(files);
        int fileIndex = UserInput.getIntInput("Which file do you want to read? ");

        return files[fileIndex - 1];
    }

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                       .replace("_", " ")
                       .substring(10);
    }

    private List<Assignment> getAllAssignments()
    {
        var files = gradesService.getFileNames();
        return gradesService.getAllAssignments(files);
    }

    private GradeStatistics createFileStatistics()
    {
        var fileName = getFileName();
        var assignments = gradesService.getAssignments(fileName);

        var studentName = parseStudentName(fileName);
        var statistics = gradeStatisticsService.buildStatistics(assignments);
        statistics.setName(studentName);

        return statistics;
    }

    private GradeStatistics createAllStudentsStatistics()
    {
        var assignments = getAllAssignments();

        var statistics = gradeStatisticsService.buildStatistics(assignments);
        statistics.setName("All Students Statistics");

        return statistics;
    }
}
