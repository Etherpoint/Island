package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
import ru.javarush.island.ryabov.util.Random;

public interface Reproducible {
    @SuppressWarnings("unused")
    default void reproduce(Cell cell) throws CloneNotSupportedException {
        cell.getLock().lock();
        Organism organism = Constants.ORGANISMS[Random.random(0, Constants.ORGANISMS.length)];
        for (Organism organismIntegerEntry : cell.CELL_POPULATION) {
            if (organismIntegerEntry instanceof Plant) {
                if (organismIntegerEntry.getClass().isAnnotationPresent(TypeData.class)) {
                    TypeData typeData = organismIntegerEntry.getClass().getAnnotation(TypeData.class);
                    if (cell.PLANTS.size() < typeData.maxCountInCell()) {
                        Plant plant = (Plant) organismIntegerEntry.clone();
                        cell.ORGANISMS.add(plant);
                        cell.PLANTS.add(plant);
                        Constants.BORNED.incrementAndGet();
                    }
                }
            } else if (organism.calculateSize(cell) >= 2) {
                if (organismIntegerEntry instanceof Predator) {
                    if (organismIntegerEntry.getClass().isAnnotationPresent(TypeData.class)) {
                        TypeData typeData = organismIntegerEntry.getClass().getAnnotation(TypeData.class);
                        if (cell.PREDATORS.size() < typeData.maxCountInCell()) {
                            Predator predator = (Predator) organismIntegerEntry.clone();
                            cell.ORGANISMS.add(predator);
                            cell.PREDATORS.add(predator);
                            Constants.BORNED.incrementAndGet();
                        }
                    }
                } else if (organismIntegerEntry instanceof Herbivore) {
                    if (organismIntegerEntry.getClass().isAnnotationPresent(TypeData.class)) {
                        TypeData typeData = organismIntegerEntry.getClass().getAnnotation(TypeData.class);
                        if (cell.HERBIVORES.size() < typeData.maxCountInCell()) {
                            Herbivore herbivore = (Herbivore) organismIntegerEntry.clone();
                            cell.ORGANISMS.add(herbivore);
                            cell.HERBIVORES.add(herbivore);
                            Constants.BORNED.incrementAndGet();
                        }
                    }
                }
            }
        }
        cell.getLock().unlock();
    }
}