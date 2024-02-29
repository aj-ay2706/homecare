package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Registerdto;

public interface Registerservice {
    Registerdto createRegister(Registerdto employeeDto);

    Registerdto getRegisterById(Long employeeId);

    List<Registerdto> getAllRegisters();
}
