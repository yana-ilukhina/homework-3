package ru.ilukhinayana.jungle.util;

import ru.ilukhinayana.jungle.entity.Elephant;

public class Event {
    //private static final int FANGS = 2;

    // 1. слон поспал +20 энергии +5 здоровья
    // 2. слон походил, ничего не нашел -7 энергии
    // 3. слон съел листьев + коэфф * 5 энергии и + 5 здоровья
    // 4. слон съел фруктов + коэфф * 4 энергии и + 5 здоровья
    // 5. слон попил воды, + коэфф * 4 энергии и + 2 здоровья
    // 6. на слона напал браконьер - 50 здоровья
    // 7. на слона напала стая львов, - энергии и - здоровья
    // 8. на слона напали крокодилы, - энергии и - здоровья
    // 9. слон впал в агрессию, - энергии и - здоровья
    // 10. слон заболел, но выздоровел, - энергии и - здоровья

    // если энергия = 0, то -5 здоровья
    // если здоровье = 0, то слон погиб

    public void activateEvent() {
        //sleepEvent();
    }

    private void sleepEvent(Elephant eleph) { // 1. слон поспал: +20 энергии +5 здоровья
        int energy = eleph.getEnergy();
        int health = eleph.getHealth();
        energy += 20;
        health += 5;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setEnergy(energy);
        eleph.setHealth(health);
        System.out.println("Слон поспал! +5 здоровья, +20 энергии. Текущие показатели: "
                + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void move(Elephant eleph) { // 2. слон походил, ничего не нашел: -7 энергии
        int energy = eleph.getEnergy();
        energy -= 7;
        checkMinMaxEnergy(eleph);
        eleph.setEnergy(energy);
        System.out.println("Слон походил просто так, немного устал! -7 энергии. Текущие показатели: "
                + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void eatLeaves(Elephant eleph) { // 3. слон поел листьев: 5 энергии * коэфф клык и + 5 здоровья
        int energy = eleph.getEnergy();
        int health = eleph.getHealth();
        energy = energy + (5 * eleph.getFANGS());
        health += 5;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setEnergy(energy);
        eleph.setHealth(health);
        System.out.println("Слон поел листьев! :) +5 здоровья, +10 энергии. Текущие показатели: "
                + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void eatFruits(Elephant eleph) { // 4. слон поел фруктов: 4 энергии * коэфф клык и + 5 здоровья
        int energy = eleph.getEnergy();
        int health = eleph.getHealth();
        energy = energy + (4 * eleph.getFANGS());
        health += 5;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setEnergy(energy);
        eleph.setHealth(health);
        System.out.println("Слон поел фруктов! :) +5 здоровья, +8 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void drinkWater(Elephant eleph) { // 5. слон попил воды: 2 энергии * коэфф клык и + 2 здоровья
        int energy = eleph.getEnergy();
        int health = eleph.getHealth();
        energy = energy + (2 * eleph.getFANGS());
        health += 2;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setEnergy(energy);
        eleph.setHealth(health);
        System.out.println("Слон попил воды! :) +2 здоровья, +4 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }


    private void checkMinMaxHealth(Elephant eleph) {
        int health = eleph.getHealth();
        if (health > 120) {
            health = 120;
            eleph.setHealth(health);
            System.out.println("Слон и так слишком здоровый :). Текущие показатели здоровья: "
                    + eleph.getHealth());
        }

        /*if (health <= 0) {
            System.out.println("*Траурная музыка* Слон погиб ;( "
                    + eleph.getHealth());
        }*/
    }

    private void checkMinMaxEnergy(Elephant eleph) {
        int energy = eleph.getEnergy();
        if (energy > 100) {
            energy = 100;
            eleph.setEnergy(energy);
            System.out.println("Слон и так бодрый! Текущие показатели: "
                    + eleph.getHealth() + " здоровья,  " + eleph.getEnergy() + " энергии");
        }
        if (energy <= 0) {
            energy = 0;
            eleph.setEnergy(energy);
            System.out.println("Слон очень устал! Текущие показатели: "
                    + eleph.getHealth() + " здоровья,  " + eleph.getEnergy() + " энергии");
        }
    }

}


