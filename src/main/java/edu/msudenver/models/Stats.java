package edu.msudenver.models;

import javax.persistence.*;

@Entity
public class Stats {

    @Id
    private long statsId;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    private int hp;
    private int attack;
    private int defense;
    private int xp;
    private int currentLevel;
    private int currentCellX;
    private int currentCellY;

    public Stats() {
    }

    public Stats(long statsId, Profile profile, int hp, int attack, int defense, int xp, int currentLevel, int currentCellX, int currentCellY) {
        this.statsId = statsId;
        this.profile = profile;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.xp = xp;
        this.currentLevel = currentLevel;
        this.currentCellX = currentCellX;
        this.currentCellY = currentCellY;
    }

    public long getStatsId() {
        return statsId;
    }

    public void setStatsId(long statsId) {
        this.statsId = statsId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
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
}