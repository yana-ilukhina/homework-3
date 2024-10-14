package ru.ilukhinayana.jungle.util;

import ru.ilukhinayana.jungle.entity.Elephant;

public class Event {

    // слон поспал +20 энергии +5 здоровья
    // слон побегал, ничего не нашел -7 энергии
    // слон съел листьев + коэфф * 5 энергии и + 5 здоровья
    // слон съел фруктов + коэфф * 4 энергии и + 5 здоровья
    // на слона напал браконьер - 50 здоровья
    //

    // если энергия = 0, то -5 здоровья

    public void activateEvent() {

    }

    private void  sleepEvent(Elephant eleph) {
        int energy = eleph.getEnergy();
        energy += 20;
        if (energy > 100) {
            energy = 100;
            }
        eleph.setEnergy(energy);
        System.out.println("Слон поспал! Текущие показатели здоровья и энергии: " + eleph.getHealth() + " " + eleph.getEnergy());
    }

}
