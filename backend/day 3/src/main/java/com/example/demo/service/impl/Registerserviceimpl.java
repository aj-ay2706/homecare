package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.dto.Registerdto;
import com.example.demo.entity.Register;
import com.example.demo.mapper.Registermapper;
import com.example.demo.repository.Registerrepo;
import com.example.demo.service.Registerservice;
import com.example.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Registerserviceimpl implements Registerservice {

    private Registerrepo registerRepository;

    @Override
    public Registerdto createRegister(Registerdto registerdto) {

        Register register = Registermapper.maptoEmployee(registerdto);
        Register savedRegister = registerRepository.save(register);
        return Registermapper.maptoEmployeeDto(savedRegister);
    }

    @Override
    public Registerdto getRegisterById(Long registerId) {
        Register register = registerRepository.findById(registerId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User is not exist with given id : " + registerId));

        return Registermapper.maptoEmployeeDto(register);
    }

    @Override
    public List<Registerdto> getAllRegisters() {
        List<Register> registers = registerRepository.findAll();

        List<Registerdto> RegisterDtos = new ArrayList<>();
        for (Register register : registers) {
            RegisterDtos.add(Registermapper.maptoEmployeeDto(register));
        }

        return RegisterDtos;
    }

}
