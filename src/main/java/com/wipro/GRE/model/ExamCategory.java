package com.wipro.GRE.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sectionId;
    private UUID examId;
    private int numberOfQuestions;
    private String typeOfQuestion;
    private int durationInMinutes;
    private float positiveMark;
    private float negativeMark;
}
