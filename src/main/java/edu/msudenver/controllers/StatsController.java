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

import java.util.ArrayList;
import java.util.List;

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
        profile.setIsActive(request.getProfile().getIsActive());
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

    @PatchMapping("/{statsId}")
    public Stats updateStats(@PathVariable Long statsId, @RequestBody StatsRequest request) {
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
        // statsToUpdate.getProfile().setAccountId(request.getProfile().getAccountId());
        statsToUpdate.getProfile().setClassType(request.getProfile().getClassType());
        statsToUpdate.getProfile().setGender(request.getProfile().getGender());
        statsToUpdate.getProfile().setIsActive(request.getProfile().getIsActive());
        statsToUpdate.getProfile().setOrigins(request.getProfile().getOrigins());
        statsToUpdate.getProfile().setProfileName(request.getProfile().getProfileName());
        statsToUpdate.getProfile().getAccount().setEmail(request.getProfile().getAccount().getEmail());
        statsToUpdate.getProfile().getAccount().setGamerTag(request.getProfile().getAccount().getGamerTag());
        statsToUpdate.getProfile().getAccount().setPassword(request.getProfile().getAccount().getPassword());
        statsToUpdate.getProfile().getAccount().setStatus(request.getProfile().getAccount().getStatus());
        statsToUpdate.setXp(request.getXp());

        return statsRepository.save(statsToUpdate);
    }
}