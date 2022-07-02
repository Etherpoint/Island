package ru.javarush.island.ryabov.interfaces;

import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;

public interface Reproducible {
    void reproduce(Cell cell);
}
