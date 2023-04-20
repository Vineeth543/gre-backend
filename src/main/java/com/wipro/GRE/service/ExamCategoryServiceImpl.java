package com.wipro.GRE.service;

import com.wipro.GRE.model.ExamCategory;
import com.wipro.GRE.repository.ExamCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ExamCategoryServiceImpl implements ExamCategoryService {

    private final ExamCategoryRepository examCategoryRepository;

    public ExamCategoryServiceImpl(ExamCategoryRepository examCategoryRepository) {
        this.examCategoryRepository = examCategoryRepository;
    }


    @Override
    public ExamCategory createExamCategory(UUID examId, ExamCategory examCategory) {
        examCategory.setExamId(examId);
        return examCategoryRepository.save(examCategory);
    }

    @Override
    public ExamCategory getExamCategory(UUID examId, int sectionId) {
        return examCategoryRepository.findByExamIdAndSectionId(examId, sectionId);
    }

    @Override
    public ExamCategory updateExamCategory(UUID examId, int sectionId, ExamCategory examCategory) {
        ExamCategory existingExamCategory = examCategoryRepository.findByExamIdAndSectionId(examId, sectionId);
        existingExamCategory.setNumberOfQuestions(examCategory.getNumberOfQuestions());
        existingExamCategory.setTypeOfQuestion(examCategory.getTypeOfQuestion());
        existingExamCategory.setDurationInMinutes(examCategory.getDurationInMinutes());
        existingExamCategory.setPositiveMark(examCategory.getPositiveMark());
        existingExamCategory.setNegativeMark(examCategory.getNegativeMark());
        return examCategoryRepository.save(existingExamCategory);
    }
    @Transactional
    @Override
    public void deleteExamCategory(UUID examId, int sectionId) {
        examCategoryRepository.deleteByExamIdAndSectionId(examId, sectionId);
    }

    @Override
    public List<ExamCategory> getAllExamCategory() {
        return examCategoryRepository.findAll();
    }
}

