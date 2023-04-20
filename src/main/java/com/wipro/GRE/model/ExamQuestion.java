package com.wipro.GRE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamQuestion {
    private UUID examId;
    private int sectionId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int examQuestionId;
    private String question;
    private List<String> options;
    private int correctOptionIndex;
}
