package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
import ru.javarush.island.ryabov.util.Random;

public interface Eating {
    default void eat(Cell cell) {
        cell.getLock().lock();
        if (this instanceof Predator) {
            if (cell.HERBIVORES.size() != 0) {
                Herbivore herbivore = cell.HERBIVORES.get(Random.random(0, cell.HERBIVORES.size()));
                synchronized (cell) {
                    cell.HERBIVORES.remove(herbivore);
                    cell.ORGANISMS.remove(herbivore);
                    Constants.EATEN.incrementAndGet();
                }
            }
        } else {
            if (cell.PLANTS.size() != 0) {
                Plant plant = cell.PLANTS.get(Random.random(0, cell.PLANTS.size()));
                synchronized (cell) {
                    cell.PLANTS.remove(plant);
                    cell.ORGANISMS.remove(plant);
                    Constants.EATEN.incrementAndGet();
                }
            }
        }
        cell.getLock().unlock();
    }
}
