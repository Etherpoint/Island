package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
import ru.javarush.island.ryabov.util.Random;
import java.util.Map;

public interface Eating {
    default void eat(Cell cell){
        if (this instanceof Predator){
            Herbivore herbivore = cell.HERBIVORES.get(Random.random(0, cell.HERBIVORES.size()));
            //TODO добавить вероятности
            cell.HERBIVORES.remove(herbivore);
            for (Map.Entry<Organism, Integer> organismIntegerEntry : cell.CELL_POPULATION.entrySet()) {
                if (organismIntegerEntry.getKey().equals(herbivore)){
                    cell.CELL_POPULATION.put(organismIntegerEntry.getKey(), organismIntegerEntry.getValue()-1);
                }
            }
        }else{
            Plant plant = cell.PLANTS.get(Random.random(0, cell.PLANTS.size()));
            //TODO добавить вероятности
            cell.PLANTS.remove(plant);
            for (Map.Entry<Organism, Integer> organismIntegerEntry : cell.CELL_POPULATION.entrySet()) {
                if (organismIntegerEntry.getKey().equals(plant)){
                    cell.CELL_POPULATION.put(organismIntegerEntry.getKey(), organismIntegerEntry.getValue()-1);
                }
            }
        }
    }
}
