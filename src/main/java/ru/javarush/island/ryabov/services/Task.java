package ru.javarush.island.ryabov.services;

import lombok.Getter;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.types.Animal;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;

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
            animal.eat(cell);
//            animal.reproduce(cell);
//            animal.move(cell);
        } else {
            organism.reproduce(cell);
        }
    }

}