package com.wipro.GRE.service;

import com.wipro.GRE.model.ExaminationSchedule;

import java.util.List;
import java.util.UUID;

public interface ExamScheduleService {
    ExaminationSchedule createExaminationSchedule(ExaminationSchedule examinationSchedule);

    ExaminationSchedule getExaminationSchedule(UUID examId);

    ExaminationSchedule updateExaminationSchedule(UUID examId, ExaminationSchedule examinationSchedule);

    void deleteExaminationSchedule(UUID examId);

    List<ExaminationSchedule> findall();
}
