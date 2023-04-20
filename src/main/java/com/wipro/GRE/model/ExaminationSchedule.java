package com.wipro.GRE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExaminationSchedule {
    @Id
    @GeneratedValue(generator = "system-uuid")
    private UUID examId;
    private String examName;
    private LocalDateTime examDate;
    private int durationInMinutes;
    private String instructions;
    private LocalDateTime startTime;

}
