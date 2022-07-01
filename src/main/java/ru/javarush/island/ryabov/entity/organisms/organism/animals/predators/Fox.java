package ru.javarush.island.ryabov.entity.organisms.organism.animals.predators;

import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;

public class Fox extends Predator {
    public Fox (String name, String icon, Limit limit){
        super(name, icon, limit);
    }

    @Override
    public void move(int row, int col) {

    }

    @Override
    public void eat(Herbivore herbivore) {

    }

    @Override
    public void reproduce(Organism organism) {

    }
}
