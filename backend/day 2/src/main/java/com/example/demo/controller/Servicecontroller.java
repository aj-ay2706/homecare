package com.example.demo.controller;

import com.example.demo.dto.Servicedto;
import com.example.demo.service.Serviceservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class Servicecontroller {

    private final Serviceservice serviceService;

    public Servicecontroller(Serviceservice serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ResponseEntity<Servicedto> createService(@RequestBody Servicedto servicedto) {
        Servicedto createdService = serviceService.createService(servicedto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdService);
    }

    @GetMapping
    public ResponseEntity<List<Servicedto>> getAllServices() {
        List<Servicedto> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<Servicedto> updateService(@PathVariable Long serviceId, @RequestBody Servicedto updatedServiceDto) {
        Servicedto updatedService = serviceService.updateService(serviceId, updatedServiceDto);
        return ResponseEntity.ok(updatedService);
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId) {
        serviceService.deleteService(serviceId);
        return ResponseEntity.noContent().build();
    }
}