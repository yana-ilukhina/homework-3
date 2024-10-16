package ru.ilukhinayana.jungle.util;

import ru.ilukhinayana.jungle.entity.Elephant;

public class EventSimulator {

    // 1. Слон поспал: +5 здоровья и +20 энергии
    // 2. Слон походил, ничего не нашел: -7 энергии
    // 3. Слон поел листьев: +5 здоровья и +5 энергии * коэфф клык
    // 4. Слон поел фруктов: +5 здоровья и +4 энергии * коэфф клык
    // 5. Слон попил воды: +2 здоровья и +2 энергии * коэфф клык
    // 6. На слона напал браконьер: -50 здоровья -50 энергии
    // 7. На слона напали львы: -20 здоровья и -30 энергии
    // 8. На слона напал крокодил: -15 здоровья и -20 энергии
    // 9. Слон впал в агрессию, гон, муст: -5 здоровья и -20 энергии
    // 10. Сон заболел, но выздоровел, -15 здоровья и -20 энергии

    // Вероятность каждого события - 10%, а заболеть 11%

    // если энергия < 0, то -5 здоровья
    // если здоровье = 0, то слон погиб

    String emojElephant = "\ud83d\udc18";

    public void startSimulation(Elephant eleph) throws InterruptedException {
        String dice = "\ud83c\udfb2"; // эмодзи игральные кости
        int eventNumber;
        while (isAlive(eleph)) {
            eventNumber = (int) (Math.random() * 100);
            System.out.println(dice +" " + eventNumber + "...");
            Thread.sleep(1000);
            if (eventNumber < 10) {
                sleepEvent(eleph);
            } else if (eventNumber < 20) {
                move(eleph);
            } else if (eventNumber < 30) {
                eatLeaves(eleph);
            } else if (eventNumber < 40) {
                eatFruits(eleph);
            } else if (eventNumber < 50) {
                drinkWater(eleph);
            } else if (eventNumber < 60) {
                poacherAttack(eleph);
            } else if (eventNumber < 70) {
                lionsAttack(eleph);
            } else if (eventNumber < 80) {
                crocodileAttack(eleph);
            } else if (eventNumber < 90) {
                aggressiveTime(eleph);
            } else if (eventNumber <= 100) {
                illnessTime(eleph);
            }
        }
        System.out.println("*Траурная музыка* Ооо нет! Слон погиб ;( " + emojElephant + eleph.getHealth() + " здоровья");
    }

    private void sleepEvent(Elephant eleph) { // 1. слон поспал: +5 здоровья и +20 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health += 5;
        energy += 20;
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("Слон поспал! +5 здоровья, +20 энергии.");
//        Текущие показатели: "+ eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void move(Elephant eleph) { // 2. слон походил, ничего не нашел: -7 энергии
        int energy = eleph.getEnergy();
        energy -= 7;
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        System.out.println("Слон походил просто так, немного устал! -7 энергии. ");
                //"Текущие показатели: "+ eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void eatLeaves(Elephant eleph) { // 3. слон поел листьев: +5 здоровья и +5 энергии * коэфф клык
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health += 5;
        energy = energy + (int) (5 * eleph.getFANGS());
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("Слон поел листьев! :) +5 здоровья, +10 энергии. ");
                //"Текущие показатели: + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void eatFruits(Elephant eleph) { // 4. слон поел фруктов: +5 здоровья и +4 энергии * коэфф клык
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health += 5;
        energy = energy + (int) (4 * eleph.getFANGS());
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("Слон поел фруктов! :) +5 здоровья, +8 энергии. ");
//                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void drinkWater(Elephant eleph) { // 5. слон попил воды: +2 здоровья и +2 энергии * коэфф клык
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health += 2;
        energy = energy + (int) (2 * eleph.getFANGS());
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("Слон попил воды! :) +2 здоровья, +4 энергии. ");
//                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void poacherAttack(Elephant eleph) { // 6. на слона напал браконьер: - 50 здоровья - 50 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 50;
        energy -= 50;
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("На слона напал браконьер! :( -50 здоровья, -50 энергии. ");
//                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void lionsAttack(Elephant eleph) { // 7. на слона напали львы: -20 здоровья и -30 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 20;
        energy -= 30;
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("На слона напали львы! :( -20 здоровья, -30 энергии. ");
//                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void crocodileAttack(Elephant eleph) { // 8. на слона напал крокодил: -15 здоровья и -20 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 15;
        energy -= 20;
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("На слона напал крокодил! :( -15 здоровья, -20 энергии. ");
//                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void aggressiveTime(Elephant eleph) { // 9. слон впал в агрессию, гон, муст: -5 здоровья и -20 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 5;
        energy -= 20;
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("У слона гон, он впал в агресcию! :( -5 здоровья, -20 энергии. ");
//                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void illnessTime(Elephant eleph) { // 10. слон заболел, но выздоровел, -15 здоровья и -20 энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        health -= 15;
        energy -= 20;
        eleph.setHealth(health);
        eleph.setEnergy(energy);
        checkMinMaxEnergy(eleph);
        checkMaxHealth(eleph);
        System.out.println("Слон заболел, но выздоровел! -15 здоровья, -20 энергии. ");
//                "Текущие показатели: " + eleph.getHealth() + " здоровья, " + eleph.getEnergy() + " энергии");
    }

    private void checkMaxHealth(Elephant eleph) {
        int health = eleph.getHealth();
        if (health > 120) {
            health = 120;
            eleph.setHealth(health);
//            System.out.println("Слон и так здоровый :). Текущие показатели здоровья: "+ eleph.getHealth());
        }
    }

    private boolean isAlive(Elephant eleph) { // проверка жив ли ещё слон -- на минимальное здоровье
        System.out.println("Текущие показатели: " + eleph.getHealth() + " hp, " + eleph.getEnergy() + " energy");
        int health = eleph.getHealth();
        return health > 0;
    }

    private void checkMinMaxEnergy(Elephant eleph) { // проверка минимальной и максимальной энергии
        int health = eleph.getHealth();
        int energy = eleph.getEnergy();
        if (energy > 100) {
            energy = 100;
            eleph.setEnergy(energy);
//            System.out.println("Слон и так бодрый! Текущие показатели: "
//                    + eleph.getHealth() + " здоровья,  " + eleph.getEnergy() + " энергии");
        }
        if (energy < 0) {
            energy = 0;
            health -= 5;
            eleph.setHealth(health);
            eleph.setEnergy(energy);
//            System.out.println("Слон очень устал! -5 здоровья. Текущие показатели: "
//                    + eleph.getHealth() + " здоровья,  " + eleph.getEnergy() + " энергии");
        }
    } // можно объединить проверку на макс здоровье и мин-макс энергии, но как назвать? И стоит ли объединять вообще?
}     // можно объединить и с проверкой isAlive, return д.б. в самом конце


