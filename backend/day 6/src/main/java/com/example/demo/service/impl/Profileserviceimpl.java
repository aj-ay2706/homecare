package com.example.demo.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.service.Profileservice;
import com.example.demo.repository.Profilerepo;
import com.example.demo.dto.Profiledto;
import com.example.demo.entity.Profile;
import com.example.demo.mapper.Profilemapper;
import com.example.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Profileserviceimpl implements Profileservice {
    private Profilerepo profileRepository;
    @Override
    public List<Profiledto> getAllProfile() {
        List<Profile> profiles = profileRepository.findAll();

        List<Profiledto> profileDtos = new ArrayList<>();
        for (Profile profile : profiles) {
            profileDtos.add(Profilemapper.maptoEmployeeDto(profile));
        }

        return profileDtos;
    }
    @Override
    public Profiledto updateProfile(Long profileId, Profiledto updatedProfileDto) {
        Profile existingProfile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("Services not found with id: " + profileId));

        // Update the existing Services with the values from updatedServicesDto
        existingProfile.setName(updatedProfileDto.getName());
        existingProfile.setEmail(updatedProfileDto.getEmail());
        existingProfile.setAge(updatedProfileDto.getAge());
        existingProfile.setGender(updatedProfileDto.getGender());
        existingProfile.setImage(updatedProfileDto.getImage());

       Profile updatedProfile = profileRepository.save(existingProfile);
        return Profilemapper.maptoEmployeeDto(updatedProfile);
    }
    @Override
    public Profiledto createProfile(Profiledto newProfileDto) {
        Profile newProfile = new Profile();
        newProfile.setName(newProfileDto.getName());
        newProfile.setEmail(newProfileDto.getEmail());
        newProfile.setAge(newProfileDto.getAge());
        newProfile.setGender(newProfileDto.getGender());
        newProfile.setImage(newProfileDto.getImage());

        Profile savedProfile = profileRepository.save(newProfile);
        return Profilemapper.maptoEmployeeDto(savedProfile);
}

}