package com.wipro.GRE.service;

import com.wipro.GRE.model.ExamCategory;


import java.util.List;
import java.util.UUID;


public interface ExamCategoryService {
    ExamCategory createExamCategory(UUID examId, ExamCategory examCategory);
    ExamCategory getExamCategory(UUID examId, int sectionId);
    ExamCategory updateExamCategory(UUID examId, int sectionId, ExamCategory examCategory);
    void deleteExamCategory(UUID examId, int sectionId);
    List<ExamCategory> getAllExamCategory();
}

