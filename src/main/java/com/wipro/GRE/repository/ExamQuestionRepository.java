package com.wipro.GRE.repository;

import com.wipro.GRE.model.ExamCategory;
import com.wipro.GRE.model.ExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Integer> {
    List<ExamQuestion> findByExamIdAndSectionId(UUID examId, int sectionId);

    ExamQuestion findByExamIdAndSectionIdAndExamQuestionId(UUID examId, int sectionId, int examQuestionId);

    void deleteByExamIdAndSectionIdAndExamQuestionId(UUID examId, int sectionId, int examQuestionId);

}
