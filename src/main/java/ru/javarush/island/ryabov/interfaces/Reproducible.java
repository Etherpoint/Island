package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
import ru.javarush.island.ryabov.util.Random;

import java.util.Map;

//TODO добавить проверку по определенным спискам
public interface Reproducible {
    default void reproduce(Cell cell) throws CloneNotSupportedException {
        cell.getLock().lock();
        if (this instanceof Predator) {
            if (cell.PREDATORS.size() > 1) {
                Predator predator = cell.PREDATORS.get(Random.random(0, cell.PREDATORS.size()));
                //TODO добавить вероятности
                synchronized (cell) {
                    cell.PREDATORS.add((Predator) predator.clone());
                    cell.ORGANISMS.add(predator.clone());
                }
                for (Map.Entry<Organism, Integer> organismIntegerEntry : cell.CELL_POPULATION.entrySet()) {
                    if (organismIntegerEntry.getKey().getClass().getSimpleName().equals(predator.getClass().getSimpleName())) {
                        cell.CELL_POPULATION.put(organismIntegerEntry.getKey(), organismIntegerEntry.getValue() + 1);
                    }
                }
            }
        } else if (this instanceof Plant) {
            if (cell.PLANTS.size() > 1) {
                Plant plant = cell.PLANTS.get(Random.random(0, cell.PLANTS.size()));
                //TODO добавить вероятности
                synchronized (cell) {
                    cell.PLANTS.add((Plant) plant.clone());
                    cell.ORGANISMS.add(plant.clone());
                }
                for (Map.Entry<Organism, Integer> organismIntegerEntry : cell.CELL_POPULATION.entrySet()) {
                    if (organismIntegerEntry.getKey().getClass().getSimpleName().equals(plant.getClass().getSimpleName())) {
                        cell.CELL_POPULATION.put(organismIntegerEntry.getKey(), organismIntegerEntry.getValue() + 1);
                    }
                }
            }
        } else if (this instanceof Herbivore) {
            if (cell.HERBIVORES.size() > 1) {
                Herbivore herbivore = cell.HERBIVORES.get(Random.random(0, cell.HERBIVORES.size()));
                //TODO добавить вероятности
                synchronized (cell) {
                    cell.HERBIVORES.add((Herbivore) herbivore.clone());
                    cell.ORGANISMS.add(herbivore.clone());
                }
                for (Map.Entry<Organism, Integer> organismIntegerEntry : cell.CELL_POPULATION.entrySet()) {
                    if (organismIntegerEntry.getKey().getClass().getSimpleName().equals(herbivore.getClass().getSimpleName())) {
                        cell.CELL_POPULATION.put(organismIntegerEntry.getKey(), organismIntegerEntry.getValue() + 1);
                    }
                }
            }
        }
        cell.getLock().unlock();
    }
}
