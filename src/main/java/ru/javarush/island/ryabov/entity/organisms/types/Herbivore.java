package ru.javarush.island.ryabov.entity.organisms.types;

import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.interfaces.HerbivoreEating;
import ru.javarush.island.ryabov.interfaces.Movable;
import ru.javarush.island.ryabov.interfaces.Reproducible;

public abstract class Herbivore extends Animal implements Movable, Reproducible, HerbivoreEating {
    public Herbivore(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
