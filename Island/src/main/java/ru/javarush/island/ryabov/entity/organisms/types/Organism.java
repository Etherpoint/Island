package ru.javarush.island.ryabov.entity.organisms.types;

import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.util.Random;

public abstract class Organism {
    private final String NAME;
    private final String ICON;
    private final Limit LIMIT;

    private int COORDINATE_ROW;
    private int COORDINATE_COL;
    private final double WEIGHT;

    public Organism(String name, String icon, Limit limit) {
        this.NAME = name;
        this.ICON = icon;
        this.LIMIT = limit;
        WEIGHT = Random.random(LIMIT.getMaxWeight()/2, LIMIT.getMaxWeight());
    }
}
