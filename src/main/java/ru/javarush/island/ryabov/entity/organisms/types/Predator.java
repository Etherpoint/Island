package ru.javarush.island.ryabov.entity.organisms.types;

import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.interfaces.Movable;
import ru.javarush.island.ryabov.interfaces.PredatorEating;
import ru.javarush.island.ryabov.interfaces.Reproducible;

public abstract class Predator extends Animal implements Movable, Reproducible, PredatorEating {
    public Predator(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
