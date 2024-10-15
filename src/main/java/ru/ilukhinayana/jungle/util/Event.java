package ru.ilukhinayana.jungle.util;

import ru.ilukhinayana.jungle.entity.Elephant;

public class Event {
    //private static final int FANGS = 2;

    // 1. Слон поспал: +5 здоровья и +20 энергии
    // 2. Слон походил, ничего не нашел: -7 энергии
    // 3. Слон поел листьев: +5 здоровья и +5 энергии * коэфф клык
    // 4. Слон поел фруктов: +5 здоровья и +4 энергии * коэфф клык
    // 5. Слон попил воды: +2 здоровья и +2 энергии * коэфф клык
    // 6. На слона напал браконьер: -50 здоровья -50 энергии
    // 7. нНа слона напали львы: -20 здоровья и -30 энергии
    // 8. На слона напал крокодил: -15 здоровья и -20 энергии
    // 9. Слон впал в агрессию, гон, муст: -5 здоровья и -20 энергии
    // 10. Сон заболел, но выздоровел, -15 здоровья и -20 энергии

    // если энергия < 0, то -5 здоровья
    // если здоровье = 0, то слон погиб

    public void activateEvent() {
        //sleepEvent();
    }

    private void sleepEvent(Elephant eleph) { // 1. слон поспал: +5 здоровья и +20 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health += 5;
        energy += 20;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
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

    private void eatLeaves(Elephant eleph) { // 3. слон поел листьев: +5 здоровья и +5 энергии * коэфф клык
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health += 5;
        energy = energy + (5 * eleph.getFANGS());
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        System.out.println("Слон поел листьев! :) +5 здоровья, +10 энергии. Текущие показатели: "
                + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void eatFruits(Elephant eleph) { // 4. слон поел фруктов: +5 здоровья и +4 энергии * коэфф клык
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health += 5;
        energy = energy + (4 * eleph.getFANGS());
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        System.out.println("Слон поел фруктов! :) +5 здоровья, +8 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void drinkWater(Elephant eleph) { // 5. слон попил воды: +2 здоровья и +2 энергии * коэфф клык
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health += 2;
        energy = energy + (2 * eleph.getFANGS());
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        System.out.println("Слон попил воды! :) +2 здоровья, +4 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void poacherAttack(Elephant eleph) { // 6. на слона напал браконьер: - 50 здоровья - 50 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 50;
        energy -= 50;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        System.out.println("На слона напал браконьер! :( -50 здоровья, -50 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void lionsAttack(Elephant eleph) { // 7. на слона напали львы: -20 здоровья и -30 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 20;
        energy -= 30;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        System.out.println("На слона напали львы! :( -20 здоровья, -30 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void crocodileAttack(Elephant eleph) { // 8. на слона напал крокодил: -15 здоровья и -20 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 15;
        energy -= 20;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        System.out.println("На слона напал крокодил! :( -15 здоровья, -20 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void aggressiveTime(Elephant eleph) { // 9. слон впал в агрессию, гон, муст: -5 здоровья и -20 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 5;
        energy -= 20;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        System.out.println("У слона гон, он впал в агресию! :( -5 здоровья, -20 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void illnessTime(Elephant eleph) { // 10. слон заболел, но выздоровел, -15 здоровья и -20 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 15;
        energy -= 20;
        checkMinMaxEnergy(eleph);
        checkMinMaxHealth(eleph);
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        System.out.println("Слон заболел, но выздоровел! -15 здоровья, -20 энергии. " +
                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + "энергии");
    }

    private void checkMinMaxHealth(Elephant eleph) {
        int health = eleph.getHealth();
        if (health > 120) {
            health = 120;
            eleph.setHealth(health);
            System.out.println("Слон и так здоровый :). Текущие показатели здоровья: "
                    + eleph.getHealth());
        }

        /*if (health <= 0) {
            System.out.println("*Траурная музыка* Слон погиб ;( "
                    + eleph.getHealth());
        }*/
    }

    private void checkMinMaxEnergy(Elephant eleph) {
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        if (energy > 100) {
            energy = 100;
            eleph.setEnergy(energy);
            System.out.println("Слон и так бодрый! Текущие показатели: "
                    + eleph.getHealth() + " здоровья,  " + eleph.getEnergy() + " энергии");
        }
        if (energy < 0) {
            energy = 0;
            health -= 5;
            eleph.setEnergy(energy);
            eleph.setHealth(health);
            System.out.println("Слон очень устал! -5 здоровья. Текущие показатели: "
                    + eleph.getHealth() + " здоровья,  " + eleph.getEnergy() + " энергии");
        }
    }

}


