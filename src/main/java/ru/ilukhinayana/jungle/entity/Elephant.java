package ru.ilukhinayana.jungle.entity;

public class Elephant {
    private int health = 120; // здоровье животного
    private int energy = 100; // энергия животного
    private final double FANGS = 2.2; // коэффициент клыков у животного

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health; //(this.?)
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getFANGS() {
        return this.FANGS;
    }
}
