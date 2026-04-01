package com.grupo1.cursosvulcano.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grupo1.cursosvulcano.model.entity.UserProfile;
import com.grupo1.cursosvulcano.repository.UserProfileRepository;

@Service
public class UserProfileService {

    private UserProfileRepository userProfileRepository;

    public List<UserProfile> getAllProfiles(){
        return userProfileRepository.findAll();
    }

    public UserProfile saveProfile(UserProfile profile) {
        return userProfileRepository.save(profile);
    }

}
