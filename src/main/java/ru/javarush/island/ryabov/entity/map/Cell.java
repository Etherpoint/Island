package ru.javarush.island.ryabov.entity.map;

import lombok.Getter;
import ru.javarush.island.ryabov.entity.organisms.organism.plant.Plant;
import ru.javarush.island.ryabov.entity.organisms.types.Herbivore;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.entity.organisms.types.Predator;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {

    public List<Organism> CELL_POPULATION = new ArrayList<>();

    public List<Predator> PREDATORS = new ArrayList<>();
    public List<Herbivore> HERBIVORES = new ArrayList<>();
    public List<Plant> PLANTS = new ArrayList<>();
    public List<Organism> ORGANISMS = new ArrayList<>();

    @Getter
    private final Lock lock = new ReentrantLock(true);
    private final List<Cell> nextCell = new ArrayList<>();

    public void updateNextCell(GameMap map, int row, int col) {
        Cell[][] cells = map.getCells();
        if (row > 0) nextCell.add(cells[row - 1][col]);
        if (col > 0) nextCell.add(cells[row][col - 1]);
        if (row < map.getRows() - 1) nextCell.add(cells[row + 1][col]);
        if (col < map.getCols() - 1) nextCell.add(cells[row][col + 1]);
    }
}
