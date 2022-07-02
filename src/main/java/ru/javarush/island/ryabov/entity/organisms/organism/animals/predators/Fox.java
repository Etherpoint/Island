package ru.javarush.island.ryabov.entity.organisms.organism.animals.predators;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
@TypeData(name = "Лиса", icon = "\uD83E\uDD8A", maxWeight = 8, maxCountInCell = 30, maxSpeed = 2, maxFood = 2)

public class Fox extends Predator {
    public Fox (String name, String icon, Limit limit){
        super(name, icon, limit);
    }

    @Override
    public void eat(Cell cell) {

    }

    @Override
    public void move(Cell cell) {

    }

    @Override
    public void reproduce(Cell cell) {

    }
}
