package ru.javarush.island.ryabov.entity.organisms.organism.plant;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
@TypeData(name = "Растение", icon = "\uD83C\uDF38", maxWeight = 1, maxCountInCell = 200, maxSpeed = 0, maxFood = 0)

public class Plant extends Organism {
    public Plant(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

    @Override
    public void reproduce(Cell cell) {

    }
}
