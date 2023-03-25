package edu.msudenver.services;

import edu.msudenver.models.Profile;
import edu.msudenver.models.ProfileRequest;
import edu.msudenver.models.ProfileResponse;

import java.util.List;

public interface ProfileService {

    List<Profile> getProfileByAccountId(Long accountId);

    ProfileResponse createProfile(ProfileRequest profileRequest);

    List<Profile> getAllProfiles();

    Profile getProfileById(Long profileId);

    Profile updateProfile(Long profileId, ProfileRequest profileRequest);

    void deleteProfileById(Long profileId);

}