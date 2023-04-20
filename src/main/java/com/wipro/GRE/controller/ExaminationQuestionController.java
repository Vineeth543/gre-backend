package com.wipro.GRE.controller;

import com.wipro.GRE.model.ExamQuestion;
import com.wipro.GRE.repository.ExamQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/examination-question")
public class ExaminationQuestionController {

    @Autowired
    private ExamQuestionRepository examinationQuestionRepository;

    // Create operation
    @PostMapping
    public ExamQuestion createExaminationQuestion(@RequestBody ExamQuestion examinationQuestion) {
        return examinationQuestionRepository.save(examinationQuestion);
    }

    // Read operation
    @GetMapping("/{examId}/categories/{sectionId}/question/{id}")
    public ExamQuestion getExaminationQuestion(@PathVariable UUID examId, @PathVariable int sectionId ,@PathVariable("id") Integer id) {
        return examinationQuestionRepository.findByExamIdAndSectionIdAndExamQuestionId(examId,sectionId,id);
    }

    // Update operation
    @PutMapping("/{examId}/categories/{sectionId}/question/{id}")
    public ExamQuestion updateExaminationQuestion(@PathVariable UUID examId, @PathVariable int sectionId ,@PathVariable("id") Integer id, @RequestBody ExamQuestion updatedExaminationQuestion) {
        ExamQuestion existingExaminationQuestion = examinationQuestionRepository.findByExamIdAndSectionIdAndExamQuestionId(examId,sectionId,id);
        existingExaminationQuestion.setExamId(updatedExaminationQuestion.getExamId());
        existingExaminationQuestion.setSectionId(updatedExaminationQuestion.getSectionId());
        existingExaminationQuestion.setQuestion(updatedExaminationQuestion.getQuestion());
        existingExaminationQuestion.setOptions(updatedExaminationQuestion.getOptions());
        existingExaminationQuestion.setCorrectOptionIndex(updatedExaminationQuestion.getCorrectOptionIndex());
        return examinationQuestionRepository.save(existingExaminationQuestion);
    }

    // Delete operation
    @Transactional
    @DeleteMapping("/{examId}/categories/{sectionId}/question/{id}")
    public ResponseEntity<Void> deleteExaminationQuestion(@PathVariable UUID examId, @PathVariable int sectionId ,@PathVariable("id") Integer id) {
        examinationQuestionRepository.deleteByExamIdAndSectionIdAndExamQuestionId(examId,sectionId,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{examId}/categories/{sectionId}")
    public List<ExamQuestion> getAllExaminationQuestion(@PathVariable UUID examId, @PathVariable int sectionId) {
        return examinationQuestionRepository.findByExamIdAndSectionId(examId,sectionId);
    }

}
