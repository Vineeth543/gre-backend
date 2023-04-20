package com.wipro.GRE.service;

import com.wipro.GRE.model.ExaminationSchedule;
import com.wipro.GRE.repository.ExaminationScheduleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExamScheduleServiceImpl implements ExamScheduleService {
    private final ExaminationScheduleRepository examinationScheduleRepository;

    public ExamScheduleServiceImpl(ExaminationScheduleRepository examinationScheduleRepository) {
        this.examinationScheduleRepository = examinationScheduleRepository;
    }

    @Override
    public ExaminationSchedule createExaminationSchedule(ExaminationSchedule examinationSchedule) {
        examinationSchedule.setExamId(UUID.randomUUID());
        return examinationScheduleRepository.save(examinationSchedule);
    }

    @Override
    public ExaminationSchedule getExaminationSchedule(UUID examId) {
        return examinationScheduleRepository.findById(examId)
                .orElseThrow(() -> new EntityNotFoundException("ExaminationSchedule not found with id: " + examId));
    }

    @Override
    public ExaminationSchedule updateExaminationSchedule(UUID examId, ExaminationSchedule examinationSchedule) {
        ExaminationSchedule existingExaminationSchedule = examinationScheduleRepository.findById(examId)
                .orElseThrow(() -> new EntityNotFoundException("ExaminationSchedule not found with id: " + examId));

        existingExaminationSchedule.setExamName(examinationSchedule.getExamName());
        existingExaminationSchedule.setExamDate(examinationSchedule.getExamDate());
        existingExaminationSchedule.setDurationInMinutes(examinationSchedule.getDurationInMinutes());
        existingExaminationSchedule.setInstructions(examinationSchedule.getInstructions());
        existingExaminationSchedule.setStartTime(examinationSchedule.getStartTime());

        return examinationScheduleRepository.save(existingExaminationSchedule);
    }

    @Override
    public void deleteExaminationSchedule(UUID examId) {
        examinationScheduleRepository.deleteById(examId);
    }

    @Override
    public List<ExaminationSchedule> findall() {
        return examinationScheduleRepository.findAll();
    }
}
