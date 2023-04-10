package edu.msudenver.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "catalog")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalogId;

    private String name;

    private String type;

    private int level;

    private int health;

    private int speed;

    private int attack;

    private int defense;

    private int expGranted;

    private boolean canBeEquipped;

    private boolean equipped;

    private boolean canBeLooted;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> loot;

    private int lootSize;

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public int getExpGranted() {
        return expGranted;
    }

    public void setExpGranted(int expGranted) {
        this.expGranted = expGranted;
    }

    public boolean isCanBeEquipped() {
        return canBeEquipped;
    }

    public void setCanBeEquipped(boolean canBeEquipped) {
        this.canBeEquipped = canBeEquipped;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public boolean isCanBeLooted() {
        return canBeLooted;
    }

    public void setCanBeLooted(boolean canBeLooted) {
        this.canBeLooted = canBeLooted;
    }

    public List<String> getLoot() {
        return loot;
    }

    public void setLoot(List<String> loot) {
        this.loot = loot;
    }

    public int getLootSize() {
        return lootSize;
    }

    public void setLootSize(int lootSize) {
        this.lootSize = lootSize;
    }
}
