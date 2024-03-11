package com.example.demo.controller;

import com.example.demo.entity.buyservice;
import com.example.demo.repository.buyservicerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// import java.util.Optional;

@RestController
@RequestMapping("/api/buyservice")
public class buyservicecontroller {

    @Autowired
    private buyservicerepo buyserviceRepository;

    // GET all buyservices
    @GetMapping("/get")
    public ResponseEntity<List<buyservice>> getAllBuyservices() {
        List<buyservice> buyservices = buyserviceRepository.findAll();
        return new ResponseEntity<>(buyservices, HttpStatus.OK);
    }

    // GET a buyservice by ID
    // @GetMapping("/{id}")
    // public ResponseEntity<buyservice> getBuyserviceById(@PathVariable Long id) {
    //     Optional<buyservice> buyservice = buyserviceRepository.findById(id);
    //     return buyservice.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
    //             .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    // }

    // POST a new buyservice
    @PostMapping("/post")
    public ResponseEntity<buyservice> addBuyservice(@RequestBody buyservice buyservice) {
        buyservice newBuyservice = buyserviceRepository.save(buyservice);
        return new ResponseEntity<>(newBuyservice, HttpStatus.CREATED);
    }

    // Other methods such as PUT, DELETE can be added similarly
}