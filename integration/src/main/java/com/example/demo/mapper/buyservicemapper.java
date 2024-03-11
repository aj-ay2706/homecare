package com.example.demo.mapper;

import com.example.demo.dto.buyservicedto;
import com.example.demo.entity.buyservice;

public class buyservicemapper {
    public static buyservicedto maptoEmployeeDto(buyservice buy)
    {
        return new buyservicedto(
            buy.getId(),
            buy.getName(),
            buy.getEmail(),
            buy.getServicename(),
            buy.getDays(),
            buy.getDate()
        );
    }
    public static buyservice maptoEmployee(buyservicedto buydto)
    {
        return new buyservice(
            buydto.getId(),
            buydto.getName(),
            buydto.getEmail(),
            buydto.getServicename(),
            buydto.getDays(),
            buydto.getDate()
        );
    }
}