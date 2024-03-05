package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Profiledto;




public interface Profileservice {
   
    Profiledto updateProfile(Long profileId,Profiledto updateProfiledto);
    List<Profiledto> getAllProfile();
    Profiledto createProfile(Profiledto newProfileDto);
}

