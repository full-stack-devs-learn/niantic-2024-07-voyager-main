package com.niantic.services;

import com.niantic.models.Assignment;
import com.niantic.models.GradeStatistics;

import java.util.List;

public interface ReportService
{
    void createReport(GradeStatistics statistics, boolean showCounts);

}
