package com.wipro.GRE.repository;
import com.wipro.GRE.model.ExamCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExamCategoryRepository extends JpaRepository<ExamCategory, Integer> {
    void deleteByExamIdAndSectionId(UUID examId, int sectionId);

    ExamCategory findByExamIdAndSectionId(UUID examId, int sectionId);
}

