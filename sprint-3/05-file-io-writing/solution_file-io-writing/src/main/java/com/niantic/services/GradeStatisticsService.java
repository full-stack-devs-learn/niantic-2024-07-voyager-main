package com.niantic.services;

import com.niantic.models.Assignment;
import com.niantic.models.GradeStatistics;

import java.util.List;

public class GradeStatisticsService
{
    public GradeStatistics buildStatistics(List<Assignment> assignments)
    {
        GradeStatistics statistics = new GradeStatistics();

        var lowScore = getLowScore(assignments);
        var highScore = getHighScore(assignments);
        var averageScore = getAverageScore(assignments);
        var lowScores = getByScore(assignments, lowScore);
        var highScores = getByScore(assignments, highScore);
        var averageScores = getByRange(assignments, averageScore - 1, averageScore + 1);
        var studentCount = getStudentCount(assignments);
        var assignmentCount = getAssignmentCount(assignments);


        statistics.setLowScore(lowScore);
        statistics.setHighScore(highScore);
        statistics.setAverageScore(averageScore);
        statistics.setLowAssignments(lowScores);
        statistics.setHighAssignments(highScores);
        statistics.setAverageAssignments(averageScores);
        statistics.setNumberOfStudents(studentCount);
        statistics.setNumberOfAssignments(assignmentCount);

        return statistics;
    }

    public int getHighScore(List<Assignment> assignments){
        return assignments.stream()
                          .mapToInt(Assignment::getScore)
                          .max()
                          .orElse(0);
    }

    public int getLowScore(List<Assignment> assignments){
        return assignments.stream()
                          .mapToInt(Assignment::getScore)
                          .min()
                          .orElse(0);
    }

    public int getAverageScore(List<Assignment> assignments){
        int sum = assignments.stream()
                             .mapToInt(Assignment::getScore)
                             .sum();
        return sum / assignments.size();
    }

    public int getStudentCount(List<Assignment> assignments){
        return (int)assignments.stream()
                               .map(student -> student.getFirstName() + " " + student.getLastName())
                               .distinct()
                               .count();
    }

    public int getAssignmentCount(List<Assignment> assignments){
        return (int)assignments.stream()
                               .map(Assignment::getAssignmentName)
                               .distinct()
                               .count();
    }

    public List<Assignment> getByScore(List<Assignment> assignments, int score){
        return assignments.stream()
                          .filter(assignment -> assignment.getScore() == score)
                          .toList();
    }

    public List<Assignment> getByRange(List<Assignment> assignments, int minScore, int maxScore)
    {
        return assignments.stream()
                          .filter(assignment -> assignment.getScore() >= minScore && assignment.getScore() <= maxScore)
                          .toList();
    }


}
