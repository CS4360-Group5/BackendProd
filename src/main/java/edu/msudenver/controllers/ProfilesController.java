package edu.msudenver.controllers;


import edu.msudenver.models.*;
import edu.msudenver.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/profile")
public class ProfilesController {

    @Autowired
    private ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ProfileResponse>> getProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        List<ProfileResponse> profileResponses = new ArrayList<>();

        for (Profile profile : profiles) {
            Account account = profile.getAccount();
            AccountResponse accountResponse = new AccountResponse(
                    account.getAccountId(),
                    account.getEmail(),
                    account.getGamerTag(),
                    account.getPassword(),
                    account.getStatus()
            );
            ProfileResponse profileResponse = new ProfileResponse(
                    profile.getProfileId(),
                    profile.getProfileName(),
                    profile.getClassType(),
                    profile.getGender(),
                    profile.getOrigins(),
                    profile.isActive(),
                    accountResponse
            );
            profileResponses.add(profileResponse);
        }

        return ResponseEntity.ok(profileResponses);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<ProfileResponse>> getAccountProfiles(@PathVariable Long accountId) {
        List<Profile> profiles = profileService.getProfileByAccountId(accountId);
        if (profiles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<ProfileResponse> profileResponses = new ArrayList<>();
        for (Profile profile : profiles) {
            ProfileResponse profileResponse = new ProfileResponse(
                    profile.getProfileId(),
                    profile.getProfileName(),
                    profile.getClassType(),
                    profile.getGender(),
                    profile.getOrigins(),
                    profile.isActive(),
                    new AccountResponse(profile.getAccount().getAccountId(),
                            profile.getAccount().getEmail(),
                            profile.getAccount().getGamerTag(),
                            profile.getAccount().getPassword(),
                            profile.getAccount().getStatus()));
            profileResponses.add(profileResponse);
        }
        return ResponseEntity.ok(profileResponses);
    }

    @PostMapping
    public ResponseEntity<ProfileResponse> createProfile(@RequestBody ProfileRequest profileRequest) {
        ProfileResponse profileResponse = profileService.createProfile(profileRequest);
        return ResponseEntity.ok().body(profileResponse);
    }

    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResponse> getZoneProfile(@PathVariable Long profileId) {
        Profile profile = profileService.getProfileById(profileId);
        ProfileResponse profileResponse = new ProfileResponse(
                profile.getProfileId(),
                profile.getProfileName(),
                profile.getClassType(),
                profile.getGender(),
                profile.getOrigins(),
                profile.isActive(),
                new AccountResponse(
                        profile.getAccount().getAccountId(),
                        profile.getAccount().getEmail(),
                        profile.getAccount().getGamerTag(),
                        profile.getAccount().getPassword(),
                        profile.getAccount().getStatus()
                )
        );
        return ResponseEntity.ok(profileResponse);
    }

    @PutMapping("/{profileId}")
    public ResponseEntity<ProfileResponse> updateProfile(@PathVariable Long profileId, @RequestBody ProfileRequest profileRequest) {
        Profile updatedProfile = profileService.updateProfile(profileId, profileRequest);
        ProfileResponse profileResponse = new ProfileResponse(
                updatedProfile.getProfileId(),
                updatedProfile.getProfileName(),
                updatedProfile.getClassType(),
                updatedProfile.getGender(),
                updatedProfile.getOrigins(),
                updatedProfile.isActive(),
                new AccountResponse(updatedProfile.getAccount().getAccountId(),
                        updatedProfile.getAccount().getEmail(),
                        updatedProfile.getAccount().getGamerTag(),
                        updatedProfile.getAccount().getPassword(),
                        updatedProfile.getAccount().getStatus())
        );
        return ResponseEntity.ok(profileResponse);
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long profileId) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }

        profileService.deleteProfileById(profileId);
        return ResponseEntity.noContent().build();
    }

    // other controller methods for updating, deleting, and listing profiles
}