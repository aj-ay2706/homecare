package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.Servicedto;

public interface Serviceservice {
    Servicedto createService(Servicedto serviceDto);

    void deleteService(Long serviceId);
    Servicedto updateService(Long serviceId,Servicedto updateServicedto);
    
    List< Servicedto> getAllServices();
}
