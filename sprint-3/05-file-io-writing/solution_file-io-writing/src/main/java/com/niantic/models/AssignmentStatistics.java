package com.niantic.models;

import com.niantic.services.GradeStatisticsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class AssignmentStatistics
{
    GradeStatisticsService gradeStatisticsService = new GradeStatisticsService();

    private List<Assignment> assignments;
    private Map<String, List<Assignment>> assignmentsMap;
    private Map<String, GradeStatistics> gradeAssignments = new HashMap<>();

    public AssignmentStatistics(List<Assignment> assignments)
    {
        this.assignments = assignments;

        assignmentsMap = assignments.stream().collect(groupingBy(Assignment::getAssignmentName));
        buildMap();
    }

    private void buildMap()
    {
        assignmentsMap.forEach((assignmentName, assignments) -> {
           var gradeStatistics =  gradeStatisticsService.buildStatistics(assignments);
           gradeStatistics.setName(assignmentName);
           gradeAssignments.put(assignmentName,gradeStatistics);
        });
    }

    public Set<String> getAssignmentsNames()
    {
        return assignmentsMap.keySet();
    }

    public List<Assignment> getAssignments(String assignmentName)
    {
        return assignmentsMap.get(assignmentName);
    }

    public GradeStatistics getStatistics(String assignmentName)
    {
        return gradeAssignments.get(assignmentName);
    }


}
