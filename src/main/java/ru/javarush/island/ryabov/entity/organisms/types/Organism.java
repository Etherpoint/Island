package ru.javarush.island.ryabov.entity.organisms.types;

import lombok.Setter;
import ru.javarush.island.ryabov.entity.organisms.Limit;
import ru.javarush.island.ryabov.interfaces.Reproducible;
import ru.javarush.island.ryabov.util.Random;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Organism implements Reproducible, Cloneable {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());
    private long id = idCounter.incrementAndGet();
    private final String NAME;
    private final String ICON;
    private final Limit LIMIT;
    @Setter
    private double WEIGHT;

    public Organism(String name, String icon, Limit limit) {
        this.NAME = name;
        this.ICON = icon;
        this.LIMIT = limit;
        WEIGHT = Random.random(LIMIT.getMaxWeight() / 2, LIMIT.getMaxWeight());
    }

    public String getType() {
        return type;
    }
    private final String type = this.getClass().getSimpleName();

    @Override
    public Organism clone() throws CloneNotSupportedException {
        Organism clone = (Organism) super.clone();
        clone.id = idCounter.incrementAndGet();
        clone.WEIGHT = Random.random(LIMIT.getMaxWeight() / 2, LIMIT.getMaxWeight());
        return clone;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Organism> T clone(T original) {
        //for clients (cast to original Type)
        try {
            return (T) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }

    }

}
