package ru.javarush.island.ryabov.entity.organisms.types;

import ru.javarush.island.ryabov.entity.organisms.Limit;

public abstract class Animal extends Organism {
    public Animal(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
