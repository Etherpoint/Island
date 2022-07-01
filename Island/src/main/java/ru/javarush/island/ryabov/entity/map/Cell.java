package ru.javarush.island.ryabov.entity.map;

import ru.javarush.island.ryabov.entity.organisms.types.Organism;

import java.util.HashMap;
import java.util.Map;

public class Cell {
    private static int ROW;
    private static int COL;

    public final Map<Organism, Integer> CELL_POPULATION = new HashMap<>();

    public static int getCOL() {
        return COL;
    }

    public static void setCoordinate(int ROW, int COL) {
        Cell.ROW = ROW;
        Cell.COL = COL;
    }

    public static int getROW() {
        return ROW;
    }
}
