package ru.javarush.island.ryabov.services;

import lombok.Getter;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.types.Animal;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
import ru.javarush.island.ryabov.exception.GameException;

@Getter
public class Task {

    private final Organism organism;
    private final Cell cell;

    public Task(Organism organism, Cell cell) {
        this.organism = organism;
        this.cell = cell;
    }

    public void doTask() {
        if (organism instanceof Animal animal) {
            if (organism instanceof Predator predator) {
                try {
                    if (cell.HERBIVORES.size()>1000){
                        predator.eat(cell);
                    }
                } catch (RuntimeException e){
                    throw new GameException();
                }
            } else if (organism instanceof Herbivore herbivore) {
                try {
                    herbivore.eat(cell);
                    herbivore.reproduce(cell);
                } catch (RuntimeException | CloneNotSupportedException e) {
                    throw new GameException();
                }
            }
        } else {
            try {
                organism.reproduce(cell);
            } catch (RuntimeException | CloneNotSupportedException e) {
                throw new GameException();
            }
        }
    }
}