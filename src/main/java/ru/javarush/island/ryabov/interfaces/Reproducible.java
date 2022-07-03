package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
import ru.javarush.island.ryabov.util.Random;

import java.util.Map;

public interface Reproducible {
    @SuppressWarnings("unused")
    default void reproduce(Cell cell) throws CloneNotSupportedException {
        cell.getLock().lock();
        Organism organism = Constants.ORGANISMS[Random.random(0,Constants.ORGANISMS.length)];
        for (Organism organismIntegerEntry : cell.CELL_POPULATION) {
            if (organismIntegerEntry.getClass().getSimpleName().equals(organism.getClass().getSimpleName())) {
                if(organismIntegerEntry instanceof Plant){
                    for (int i = 1; i <= 10; i++) {
                        Plant plant = (Plant) organismIntegerEntry.clone();
                        cell.ORGANISMS.add(plant);
                        cell.PLANTS.add(plant);
                        Constants.BORNED.incrementAndGet();
                    }
                }else if (organism.calculateSize(cell)>=2){
                    if (organismIntegerEntry instanceof Predator){
                        Predator predator = (Predator) organismIntegerEntry.clone();
                        cell.ORGANISMS.add(predator);
                        cell.PREDATORS.add(predator);
                    }else if (organismIntegerEntry instanceof Herbivore){
                        Herbivore herbivore = (Herbivore) organismIntegerEntry.clone();
                        cell.ORGANISMS.add(herbivore);
                        cell.HERBIVORES.add(herbivore);

                    }
                }
            }
        }
        cell.getLock().unlock();
    }
}
