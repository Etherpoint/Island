package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;

public interface Ageing {
    default void aging(Cell cell){
        if (this instanceof Organism organism){
            int age = ((Organism) this).getLIFE_TIMER().incrementAndGet();
            if (age > 10){
                this.die(cell);
            }
        }
    }


    default void die(Cell cell) {
        cell.getLock().lock();
        Constants.DIED.incrementAndGet();
        if (this instanceof Predator) {
            synchronized (cell) {
                cell.PREDATORS.remove(this);
            }
        } else if (this instanceof Herbivore) {
            synchronized (cell) {
                cell.HERBIVORES.remove(this);
            }
        }if (this instanceof Plant) {
            synchronized (cell) {
                cell.PLANTS.remove(this);
            }
        }
        cell.ORGANISMS.remove((Organism) this);
        cell.getLock().unlock();
    }
}
