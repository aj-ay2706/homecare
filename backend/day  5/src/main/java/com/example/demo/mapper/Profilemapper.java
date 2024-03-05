package com.example.demo.mapper;

import com.example.demo.dto.Profiledto;
import com.example.demo.entity.Profile;

public class Profilemapper {

    public static Profiledto maptoEmployeeDto(Profile profile) {
        return new Profiledto(
                profile.getId(),
                profile.getName(),
                profile.getEmail(),
                profile.getGender(),
                profile.getAge(),
                profile.getImage());
    }

    public static Profile maptoEmployee(Profiledto profiledto) {
        return new Profile(
            profiledto.getId(),
            profiledto.getName(),
            profiledto.getEmail(),
            profiledto.getGender(),
            profiledto.getAge(),
            profiledto.getImage());
    }

}
