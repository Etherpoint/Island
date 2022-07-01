package ru.javarush.island.ryabov.entity.organisms.organism.animals.herbivores;

import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;

public class Sheep extends Herbivore {
    public Sheep (String name, String icon, Limit limit){
        super(name, icon, limit);
    }

    @Override
    public void eat(Plant plant) {

    }

    @Override
    public void move(int row, int col) {

    }

    @Override
    public void reproduce(Organism organism) {

    }
}
