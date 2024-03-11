package com.example.demo.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.service.Feedbackservice;
import com.example.demo.repository.Feedbackrepo;
import com.example.demo.dto.Feedbackdto;
import com.example.demo.entity.Feedback;
import com.example.demo.mapper.Feedbackmapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Feedbackimpl implements Feedbackservice {
      private Feedbackrepo feedbackRepository;
    @Override
    public List<Feedbackdto> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackRepository.findAll();

        List<Feedbackdto> feedbackDtos = new ArrayList<>();
        for (Feedback feedback : feedbacks) {
            feedbackDtos.add(Feedbackmapper.maptoEmployeeDto(feedback));
        }

        return feedbackDtos;
    }
    @Override
    public Feedbackdto createFeedback(Feedbackdto feedbackDto) {
        Feedback feedback = Feedbackmapper.maptoEmployee(feedbackDto);
        feedback = feedbackRepository.save(feedback);
        return Feedbackmapper.maptoEmployeeDto(feedback);
    }
    
}