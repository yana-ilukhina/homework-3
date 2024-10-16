package ru.ilukhinayana.jungle._main;

import ru.ilukhinayana.jungle.entity.Elephant;
import ru.ilukhinayana.jungle.util.EventSimulator;

public class _Main {

    public static void main(String[] args) throws InterruptedException {
        Elephant eleph = new Elephant();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(eleph);
    }
}
