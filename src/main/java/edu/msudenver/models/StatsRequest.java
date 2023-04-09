package edu.msudenver.models;

public class StatsRequest {

    private int attack;
    private int currentCellX;
    private int currentCellY;
    private int currentLevel;
    private int defense;
    private int hp;
    private long profileId;
    private ProfileRequest profile;
    private int xp;

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getCurrentCellX() {
        return currentCellX;
    }

    public void setCurrentCellX(int currentCellX) {
        this.currentCellX = currentCellX;
    }

    public int getCurrentCellY() {
        return currentCellY;
    }

    public void setCurrentCellY(int currentCellY) {
        this.currentCellY = currentCellY;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public long getProfileId() {
        return profileId;
    }
    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }
    public ProfileRequest getProfile() {
        return profile;
    }
    public void setProfile(ProfileRequest profile) {
        this.profile = profile;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }


}
