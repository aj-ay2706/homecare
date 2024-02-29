package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Registerdto;
import com.example.demo.service.Registerservice;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class Registercontroller {

    private Registerservice employeeService;

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<Registerdto> createRegister(@RequestBody Registerdto employeeDto) {
        Registerdto savedEmployee = employeeService.createRegister(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<Registerdto> getRegisterId(@PathVariable("id") Long employeeId) {
        Registerdto employeeDto = employeeService.getRegisterById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // Build Get All Employee REST API
    @GetMapping
    public ResponseEntity<List<Registerdto>> getAllRegisters() {
        List<Registerdto> employees = employeeService.getAllRegisters();
        return ResponseEntity.ok(employees);
    }

}

