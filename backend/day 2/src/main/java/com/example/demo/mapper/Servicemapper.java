package com.example.demo.mapper;


import com.example.demo.dto.Servicedto;
import com.example.demo.entity.Services;

public class Servicemapper {

    public static Servicedto maptoEmployeeDto(Services service) {
        return new Servicedto(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getCharge(),
                service.getImage());
    }

    public static Services maptoEmployee(Servicedto servicedto) {
        return new Services(
            servicedto.getId(),
            servicedto.getName(),
            servicedto.getDescription(),
            servicedto.getCharge(),
            servicedto.getImage());
    }

}