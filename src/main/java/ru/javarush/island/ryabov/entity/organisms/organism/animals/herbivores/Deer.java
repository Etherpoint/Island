package ru.javarush.island.ryabov.entity.organisms.organism.animals.herbivores;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;

@TypeData(name = "Олень", icon = "\uD83E\uDD8C", maxWeight = 300, maxCountInCell = 20, maxSpeed = 4, maxFood = 50)

public class Deer extends Herbivore {
    public Deer(String name, String icon, Limit limit) {
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
