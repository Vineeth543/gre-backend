package com.wipro.GRE.service;

import com.wipro.GRE.model.ExamQuestion;

public interface ExaminationQuestionService {

    ExamQuestion createExaminationQuestion(ExamQuestion examQuestion);

    ExamQuestion getExaminationQuestionById(Integer id);

    ExamQuestion updateExaminationQuestion(Integer id, ExamQuestion updatedExaminationQuestion);

    void deleteExaminationQuestion(Integer id);

}

