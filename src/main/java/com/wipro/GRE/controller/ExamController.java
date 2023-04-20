package com.wipro.GRE.controller;

import com.wipro.GRE.model.ExamCategory;
import com.wipro.GRE.model.ExaminationSchedule;
import com.wipro.GRE.service.ExamCategoryService;
import com.wipro.GRE.service.ExamScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private final  ExamCategoryService examCategoryService;

    @Autowired
    private final ExamScheduleService examinationScheduleService;

    public ExamController(ExamCategoryService examCategoryService, ExamScheduleService examinationScheduleService) {
        this.examCategoryService = examCategoryService;
        this.examinationScheduleService = examinationScheduleService;
    }

    // CRUD operations for ExamCategory

    @PostMapping("/{examId}/categories")
    public ResponseEntity<ExamCategory> createExamCategory(@PathVariable UUID examId, @RequestBody ExamCategory examCategory) {
        ExamCategory savedExamCategory = examCategoryService.createExamCategory(examId, examCategory);
        return new ResponseEntity<>(savedExamCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{examId}/categories/{sectionId}")
    public ResponseEntity<ExamCategory> getExamCategory(@PathVariable UUID examId, @PathVariable int sectionId) {
        ExamCategory examCategory = examCategoryService.getExamCategory(examId, sectionId);
        return new ResponseEntity<>(examCategory, HttpStatus.OK);
    }

    @GetMapping("/{examId}/categories")
    public ResponseEntity<List<ExamCategory>> getAllExamCategory() {
        List<ExamCategory> examCategory = examCategoryService.getAllExamCategory();
        return new ResponseEntity<>(examCategory, HttpStatus.OK);
    }

    @PutMapping("/{examId}/categories/{sectionId}")
    public ResponseEntity<ExamCategory> updateExamCategory(@PathVariable UUID examId, @PathVariable int sectionId, @RequestBody ExamCategory examCategory) {
        ExamCategory updatedExamCategory = examCategoryService.updateExamCategory(examId, sectionId, examCategory);
        return new ResponseEntity<>(updatedExamCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{examId}/categories/{sectionId}")
    public ResponseEntity<Void> deleteExamCategory(@PathVariable UUID examId, @PathVariable int sectionId) {
        examCategoryService.deleteExamCategory(examId, sectionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // CRUD operations for ExaminationSchedule

    @PostMapping
    public ResponseEntity<ExaminationSchedule> createExaminationSchedule(@RequestBody ExaminationSchedule examinationSchedule) {
        ExaminationSchedule savedExaminationSchedule = examinationScheduleService.createExaminationSchedule(examinationSchedule);
        return new ResponseEntity<>(savedExaminationSchedule, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<ExaminationSchedule>> getAllExaminationSchedule() {
        List<ExaminationSchedule> examinationSchedule = examinationScheduleService.findall();
        return new ResponseEntity<>(examinationSchedule, HttpStatus.OK);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<ExaminationSchedule> getExaminationSchedule(@PathVariable UUID examId) {
        ExaminationSchedule examinationSchedule = examinationScheduleService.getExaminationSchedule(examId);
        return new ResponseEntity<>(examinationSchedule, HttpStatus.OK);
    }

    @PutMapping("/{examId}")
    public ResponseEntity<ExaminationSchedule> updateExaminationSchedule(@PathVariable UUID examId, @RequestBody ExaminationSchedule examinationSchedule) {
        ExaminationSchedule updatedExaminationSchedule = examinationScheduleService.updateExaminationSchedule(examId, examinationSchedule);
        return new ResponseEntity<>(updatedExaminationSchedule, HttpStatus.OK);
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<Void> deleteExaminationSchedule(@PathVariable UUID examId) {
        examinationScheduleService.deleteExaminationSchedule(examId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

