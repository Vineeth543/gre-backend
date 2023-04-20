package com.wipro.GRE.service;

import com.wipro.GRE.model.ExamQuestion;
import com.wipro.GRE.repository.ExamQuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExaminationQuestionServiceImpl implements ExaminationQuestionService {

    @Autowired
    private ExamQuestionRepository examinationQuestionRepository;

    @Override
    public ExamQuestion createExaminationQuestion(ExamQuestion examQuestion) {
        return examinationQuestionRepository.save(examQuestion);
    }

    @Override
    public ExamQuestion getExaminationQuestionById(Integer id) {
        return examinationQuestionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ExaminationQuestion not found with id: " + id));
    }

    @Override
    public ExamQuestion updateExaminationQuestion(Integer id, ExamQuestion updatedExaminationQuestion) {
        ExamQuestion existingExaminationQuestion = examinationQuestionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ExaminationQuestion not found with id: " + id));
        existingExaminationQuestion.setExamId(updatedExaminationQuestion.getExamId());
        existingExaminationQuestion.setSectionId(updatedExaminationQuestion.getSectionId());
        existingExaminationQuestion.setQuestion(updatedExaminationQuestion.getQuestion());
        existingExaminationQuestion.setOptions(updatedExaminationQuestion.getOptions());
        existingExaminationQuestion.setCorrectOptionIndex(updatedExaminationQuestion.getCorrectOptionIndex());
        return examinationQuestionRepository.save(existingExaminationQuestion);
    }

    @Override
    public void deleteExaminationQuestion(Integer id) {
        examinationQuestionRepository.deleteById(id);
    }
}
