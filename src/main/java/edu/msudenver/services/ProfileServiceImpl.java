package edu.msudenver.services;

import edu.msudenver.exceptions.ResourceNotFoundException;
import edu.msudenver.models.*;
import edu.msudenver.repository.AccountRepository;
import edu.msudenver.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;
    private AccountRepository accountRepository;

    @Autowired
    public ProfileServiceImpl(AccountRepository accountRepository, ProfileRepository profileRepository) {
        this.accountRepository = accountRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getProfileByAccountId(Long accountId) {
        return profileRepository.findByAccountId(accountId);
    }

    @Override
    public ProfileResponse createProfile(ProfileRequest profileRequest) {
        // Check if account already exists
        Optional<Account> accountOptional = accountRepository.findByOptionalEmail(profileRequest.getAccount().getEmail());
        Account account;
        if (accountOptional.isPresent()) {
            // Use existing account
            account = accountOptional.get();
        } else {
            // Create new account
            account = new Account(
                    profileRequest.getAccount().getEmail(),
                    profileRequest.getAccount().getGamerTag(),
                    profileRequest.getAccount().getPassword(),
                    profileRequest.getAccount().getStatus()
            );
            accountRepository.save(account);
        }

        // Create new profile and associate it with the account
        Profile profile = new Profile();
        profile.setProfileName(profileRequest.getProfileName());
        profile.setClassType(profileRequest.getClassType());
        profile.setGender(profileRequest.getGender());
        profile.setOrigins(profileRequest.getOrigins());
        profile.setIsActive(profileRequest.getIsActive());
        profile.setAccount(account);
        profileRepository.save(profile);

        // Build response object
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
                profile.getIsActive(),
                accountResponse
        );
        return profileResponse;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileById(Long profileId) {
        return profileRepository.findById(profileId).orElse(null);
    }

    @Override
    public Profile updateProfile(Long profileId, ProfileRequest profileRequest) {
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Profile", "profileId", profileId));

        // Update profile fields
        profile.setProfileName(profileRequest.getProfileName());
        profile.setClassType(profileRequest.getClassType());
        profile.setGender(profileRequest.getGender());
        profile.setOrigins(profileRequest.getOrigins());
        profile.setIsActive(profileRequest.getIsActive());

        // Update account fields
        //Account account = profile.getAccount();
        //account.setEmail(profileRequest.getAccount().getEmail());
        //account.setGamerTag(profileRequest.getAccount().getGamerTag());
        //account.setPassword(profileRequest.getAccount().getPassword());
       // account.setStatus(profileRequest.getAccount().getStatus());

        // Save changes to database
        //profile.setAccount(accountRepository.save(account));
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfileById(Long profileId) {
        profileRepository.deleteById(profileId);
    }
}