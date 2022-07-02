package ru.javarush.island.ryabov.util;

import ru.javarush.island.ryabov.abstraction.TypeData;
import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;

public class CellCreator {
    public static Cell createCell() throws CloneNotSupportedException {
        Cell cell = new Cell();
        for (Organism organism : Constants.ORGANISMS) {
            if (organism.getClass().isAnnotationPresent(TypeData.class)) {
                TypeData typeData = organism.getClass().getAnnotation(TypeData.class);
                int count = Random.random(0, typeData.maxCountInCell());
                cell.CELL_POPULATION.put(organism, count);

                for (int i = 1; i < count; i++) {
                    if (organism instanceof Herbivore){
                        cell.HERBIVORES.add((Herbivore) organism.clone());
                    }else if (organism instanceof Predator){
                        cell.PREDATORS.add((Predator) organism.clone());
                    }else {
                        cell.PLANTS.add((Plant) organism.clone());
                    }
                }
            }
        }
        return cell;
    }
}
