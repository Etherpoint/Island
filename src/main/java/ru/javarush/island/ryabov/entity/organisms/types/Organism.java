package ru.javarush.island.ryabov.entity.organisms.types;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.interfaces.Ageing;
import ru.javarush.island.ryabov.interfaces.Reproducible;
import ru.javarush.island.ryabov.util.Random;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Organism implements Reproducible, Cloneable, Ageing {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());
    @Getter
    private final AtomicInteger LIFE_TIMER =new AtomicInteger();
    @SuppressWarnings("unused")
    private long id = idCounter.incrementAndGet();
    private final String ICON;
    private final String NAME;
    private final Limit LIMIT;
    @Setter
    @SuppressWarnings("unused")
    private double WEIGHT;

    public Organism(String name, String icon, Limit limit) {
        this.NAME = name;
        this.ICON = icon;
        this.LIMIT = limit;
        WEIGHT = Random.random(LIMIT.getMaxWeight() / 2, LIMIT.getMaxWeight());
        LIFE_TIMER.set(0);
    }

    @Override
    public Organism clone() throws CloneNotSupportedException {
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        clone.WEIGHT = Random.random(LIMIT.getMaxWeight() / 2, LIMIT.getMaxWeight());
        return clone;
    }

    public String getIcon() {
        return ICON;
    }

    public int calculateSize(Cell cell) {
        int count = 0;
        for (Organism organism : cell.ORGANISMS) {
            if (this.getClass().equals(organism.getClass())){
                count++;
            }
        }
        return count;
    }
}