package com.example.demo.controller;


import com.example.demo.dto.Feedbackdto;
import com.example.demo.service.Feedbackservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
@CrossOrigin(origins = "*")
public class Feedbackcontroller {

    private final Feedbackservice feedbackService;

    
    public Feedbackcontroller(Feedbackservice feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/getfeedback")
    public ResponseEntity<List<Feedbackdto>> getAllFeedbacks() {
        List<Feedbackdto> feedbackDtos = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbackDtos, HttpStatus.OK);
    }
    @PostMapping("/addfeedback")
    public ResponseEntity<Feedbackdto> createFeedback(@RequestBody Feedbackdto feedbackDto) {
        Feedbackdto createdFeedback = feedbackService.createFeedback(feedbackDto);
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }
  
}