package com.example.demo.mapper;

import com.example.demo.dto.Feedbackdto;
import com.example.demo.entity.Feedback;

public class Feedbackmapper {
    public static Feedbackdto maptoEmployeeDto(Feedback feedback) {
        return new Feedbackdto(
            feedback.getId(),
            feedback.getName(),
            feedback.getEmail(),
            feedback.getFeedback(),
            feedback.getRange());
    }

    public static Feedback maptoEmployee(Feedbackdto feedbackdto) {
        return new Feedback(
            feedbackdto.getId(),
            feedbackdto.getName(),
            feedbackdto.getEmail(),
            feedbackdto.getFeedback(),
            feedbackdto.getRange());
    }   
}