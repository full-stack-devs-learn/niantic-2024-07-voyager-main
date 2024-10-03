package com.niantic.models;

import java.util.List;

public class GradeStatistics
{
    private String name;
    private int lowScore;
    private int highScore;
    private int averageScore;
    private List<Assignment> lowAssignments;
    private List<Assignment> highAssignments;
    private List<Assignment> averageAssignments;
    private int numberOfStudents;
    private int numberOfAssignments;

    public GradeStatistics(String name)
    {
        this.name = name;
    }

    public GradeStatistics()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLowScore()
    {
        return lowScore;
    }

    public void setLowScore(int lowScore)
    {
        this.lowScore = lowScore;
    }

    public int getHighScore()
    {
        return highScore;
    }

    public void setHighScore(int highScore)
    {
        this.highScore = highScore;
    }

    public int getAverageScore()
    {
        return averageScore;
    }

    public void setAverageScore(int averageScore)
    {
        this.averageScore = averageScore;
    }

    public List<Assignment> getLowAssignments()
    {
        return lowAssignments;
    }

    public void setLowAssignments(List<Assignment> lowAssignments)
    {
        this.lowAssignments = lowAssignments;
    }

    public List<Assignment> getHighAssignments()
    {
        return highAssignments;
    }

    public void setHighAssignments(List<Assignment> highAssignments)
    {
        this.highAssignments = highAssignments;
    }

    public List<Assignment> getAverageAssignments()
    {
        return averageAssignments;
    }

    public void setAverageAssignments(List<Assignment> averageAssignments)
    {
        this.averageAssignments = averageAssignments;
    }

    public int getNumberOfStudents()
    {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents)
    {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfAssignments()
    {
        return numberOfAssignments;
    }

    public void setNumberOfAssignments(int numberOfAssignments)
    {
        this.numberOfAssignments = numberOfAssignments;
    }
}
