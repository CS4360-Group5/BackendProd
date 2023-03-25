package edu.msudenver.models;

public class StatsResponse {

    private int attack;
    private int currentCellX;
    private int currentCellY;
    private int currentLevel;
    private int defense;
    private int hp;
    private ProfileResponse profile;
    private long statsId;
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

    public ProfileResponse getProfile() {
        return profile;
    }

    public void setProfile(ProfileResponse profile) {
        this.profile = profile;
    }

    public long getStatsId() {
        return statsId;
    }

    public void setStatsId(long statsId) {
        this.statsId = statsId;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}