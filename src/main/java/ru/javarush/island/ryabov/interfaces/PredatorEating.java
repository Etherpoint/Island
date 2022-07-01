package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;

public interface PredatorEating {
    void eat(Herbivore herbivore);
}
