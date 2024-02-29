package com.example.demo.mapper;

import com.example.demo.dto.Registerdto;
import com.example.demo.entity.Register;

public class Registermapper {

    public static Registerdto maptoEmployeeDto(Register register) {
        return new Registerdto(
                register.getId(),
                register.getName(),
                register.getEmail(),
                register.getPassword(),
                register.getRoles());
    }

    public static Register maptoEmployee(Registerdto registerdto) {
        return new Register(
                registerdto.getId(),
                registerdto.getName(),
                registerdto.getEmail(),
                registerdto.getPassword(),
                registerdto.getRoles());
    }

}

