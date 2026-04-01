package com.grupo1.cursosvulcano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.cursosvulcano.model.entity.UserProfile;
import com.grupo1.cursosvulcano.service.UserProfileService;

@RestController
@RequestMapping("/api/userProfiles")
public class UserProfileController {

    @Autowired
    private UserProfileService profileService;

    @GetMapping
    public List<UserProfile> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @PostMapping
    public UserProfile saveProfile(@RequestBody UserProfile profile) {
        return profileService.saveProfile(profile);
    }

}
