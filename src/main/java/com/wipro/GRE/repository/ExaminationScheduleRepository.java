package com.wipro.GRE.repository;

import com.wipro.GRE.model.ExaminationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExaminationScheduleRepository extends JpaRepository<ExaminationSchedule, UUID> {
}

