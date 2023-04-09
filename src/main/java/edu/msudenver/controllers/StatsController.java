package edu.msudenver.controllers;

import edu.msudenver.models.*;
import edu.msudenver.repository.AccountRepository;
import edu.msudenver.repository.ProfileRepository;
import edu.msudenver.repository.StatsRepository;
import edu.msudenver.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/stats")
public class StatsController {
    @Autowired

    private StatsService statsService;

    @Autowired StatsRepository statsRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    AccountRepository accountRepository;



    @PostMapping
    public Stats createStats(@RequestBody StatsRequest request) {
        // Retrieve the profile and account from the database based on the IDs provided in the request
        Profile profile = profileRepository.findById(request.getProfileId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found"));
        Account account = accountRepository.findById(request.getProfile().getAccountId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        // Create a new stats object and populate it with the request data and retrieved profile and account
        Stats stats = new Stats();
        stats.setAttack(request.getAttack());
        stats.setCurrentCellX(request.getCurrentCellX());
        stats.setCurrentCellY(request.getCurrentCellY());
        stats.setCurrentLevel(request.getCurrentLevel());
        stats.setDefense(request.getDefense());
        stats.setHp(request.getHp());
        stats.setProfile(profile);
        stats.setXp(request.getXp());

        // Update the retrieved profile and account with any changed data from the request
        profile.setProfileName(request.getProfile().getProfileName());
        profile.setClassType(request.getProfile().getClassType());
        profile.setGender(request.getProfile().getGender());
        profile.setIsActive(request.getProfile().IsActive());
        profile.setOrigins(request.getProfile().getOrigins());
        account.setEmail(request.getProfile().getAccount().getEmail());
        account.setGamerTag(request.getProfile().getAccount().getGamerTag());
        account.setPassword(request.getProfile().getAccount().getPassword());
        account.setStatus(request.getProfile().getAccount().getStatus());

        // Save the changes to the database
        profileRepository.save(profile);
        accountRepository.save(account);
        return statsRepository.save(stats);
    }

    @GetMapping
    public List<StatsResponse> getAllProfileStats() {
        List<StatsResponse> responseList = new ArrayList<>();
        List<Stats> statsList = statsRepository.findAll();

        for (Stats stats : statsList) {
            StatsResponse response = new StatsResponse();
            response.setAttack(stats.getAttack());
            response.setCurrentCellX(stats.getCurrentCellX());
            response.setCurrentCellY(stats.getCurrentCellY());
            response.setCurrentLevel(stats.getCurrentLevel());
            response.setDefense(stats.getDefense());
            response.setHp(stats.getHp());
            response.setStatsId(stats.getStatsId());
            response.setXp(stats.getXp());

            Profile profile = stats.getProfile();
            ProfileResponse profileRes = new ProfileResponse();
            profileRes.setAccountId(profile.getAccount().getAccountId());
            profileRes.setClassType(profile.getClassType());
            profileRes.setGender(profile.getGender());
            profileRes.setActive(profile.getIsActive());
            profileRes.setOrigins(profile.getOrigins());
            profileRes.setProfileId(profile.getProfileId());
            profileRes.setProfileName(profile.getProfileName());
            profileRes.setAccount(profile.getAccount());

            response.setProfile(profileRes);
            responseList.add(response);
        }

        return responseList;
    }

    @GetMapping("/{statsId}")
    public ResponseEntity<StatsResponse> getStatProfileForZone(@PathVariable Long statsId) {
        // Retrieve the stats object based on the ID provided in the request
        Stats stats = statsRepository.findById(statsId).orElse(null);

        // Check if the stats object is null
        if (stats == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stats not found");
        }

        // Create a StatsResponse object and populate it with the data from the stats object
        StatsResponse response = new StatsResponse();
        response.setAttack(stats.getAttack());
        response.setCurrentCellX(stats.getCurrentCellX());
        response.setCurrentCellY(stats.getCurrentCellY());
        response.setCurrentLevel(stats.getCurrentLevel());
        response.setDefense(stats.getDefense());
        response.setHp(stats.getHp());
        response.setStatsId(stats.getStatsId());
        response.setXp(stats.getXp());

        // Populate the profile data for the response object
        Profile profile = stats.getProfile();
        ProfileResponse profileRes = new ProfileResponse();
        profileRes.setAccountId(profile.getAccount().getAccountId());
        profileRes.setClassType(profile.getClassType());
        profileRes.setGender(profile.getGender());
        profileRes.setActive(profile.getIsActive());
        profileRes.setOrigins(profile.getOrigins());
        profileRes.setProfileId(profile.getProfileId());
        profileRes.setProfileName(profile.getProfileName());
        profileRes.setAccount(profile.getAccount());

        response.setProfile(profileRes);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{statsId}")
    public ResponseEntity<Void> deleteProfileStatsStats(@PathVariable Long statsId) {
        if (statsRepository.existsById(statsId)) {
            statsRepository.deleteById(statsId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{statsId}")
    public StatsResponse patchStats(@PathVariable Long statsId, @RequestBody StatsRequest request) {
        // First, retrieve the stats object to update
        Stats statsToUpdate = statsRepository.findById(statsId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Stats not found"));

        // Update the stats object with the new values
        statsToUpdate.setAttack(request.getAttack());
        statsToUpdate.setCurrentCellX(request.getCurrentCellX());
        statsToUpdate.setCurrentCellY(request.getCurrentCellY());
        statsToUpdate.setCurrentLevel(request.getCurrentLevel());
        statsToUpdate.setDefense(request.getDefense());
        statsToUpdate.setHp(request.getHp());
        statsToUpdate.getProfile().setClassType(request.getProfile().getClassType());
        statsToUpdate.getProfile().setGender(request.getProfile().getGender());
        statsToUpdate.getProfile().setIsActive(request.getProfile().IsActive());
        statsToUpdate.getProfile().setOrigins(request.getProfile().getOrigins());
        statsToUpdate.getProfile().setProfileName(request.getProfile().getProfileName());
        statsToUpdate.getProfile().getAccount().setEmail(request.getProfile().getAccount().getEmail());
        statsToUpdate.getProfile().getAccount().setGamerTag(request.getProfile().getAccount().getGamerTag());
        statsToUpdate.getProfile().getAccount().setPassword(request.getProfile().getAccount().getPassword());
        statsToUpdate.getProfile().getAccount().setStatus(request.getProfile().getAccount().getStatus());
        statsToUpdate.setXp(request.getXp());

        statsRepository.save(statsToUpdate);

        // Create a ProfileResponse object and populate it with the updated profile data
        Profile profile = statsToUpdate.getProfile();
        ProfileResponse profileRes = new ProfileResponse();
        profileRes.setAccountId(profile.getAccount().getAccountId());
        profileRes.setClassType(profile.getClassType());
        profileRes.setGender(profile.getGender());
        profileRes.setActive(profile.getIsActive());
        profileRes.setOrigins(profile.getOrigins());
        profileRes.setProfileId(profile.getProfileId());
        profileRes.setProfileName(profile.getProfileName());
        profileRes.setAccount(profile.getAccount());

        // Create a StatsResponse object and populate it with the updated stats data
        StatsResponse response = new StatsResponse();
        response.setAttack(statsToUpdate.getAttack());
        response.setCurrentCellX(statsToUpdate.getCurrentCellX());
        response.setCurrentCellY(statsToUpdate.getCurrentCellY());
        response.setCurrentLevel(statsToUpdate.getCurrentLevel());
        response.setDefense(statsToUpdate.getDefense());
        response.setHp(statsToUpdate.getHp());
        response.setStatsId(statsToUpdate.getStatsId());
        response.setXp(statsToUpdate.getXp());
        response.setProfile(profileRes);

        return response;
    }

    @PutMapping("/{statsId}/profile/{profileId}")
    public ResponseEntity<Stats> assignStatsToProfile(@PathVariable Long statsId, @PathVariable Long profileId, @RequestBody StatsRequest request) {
        // Retrieve the stats object and the profile object based on the IDs provided in the request
        Stats stats = statsRepository.findById(statsId).orElse(null);
        Profile profile = profileRepository.findById(profileId).orElse(null);

        // Check if the stats or profile object is null
        if (stats == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stats not found");
        }
        if (profile == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found");
        }

        // Update the stats object with the new values
        stats.setAttack(request.getAttack());
        stats.setCurrentCellX(request.getCurrentCellX());
        stats.setCurrentCellY(request.getCurrentCellY());
        stats.setCurrentLevel(request.getCurrentLevel());
        stats.setDefense(request.getDefense());
        stats.setHp(request.getHp());
        stats.setXp(request.getXp());

        // Update the profile object with the new values
        profile.setProfileName(request.getProfile().getProfileName());
        profile.setClassType(request.getProfile().getClassType());
        profile.setGender(request.getProfile().getGender());
        profile.setIsActive(request.getProfile().IsActive());
        profile.setOrigins(request.getProfile().getOrigins());

        // Find the account object based on the email in the request
        Account account = accountRepository.findByEmail(request.getProfile().getAccount().getEmail());
        if (account == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        profile.setAccount(account);

        // Set the updated profile to the stats object
        stats.setProfile(profile);

        // Save the changes to the database
        profileRepository.save(profile);
        return ResponseEntity.ok(statsRepository.save(stats));
    }

}