package ru.javarush.island.ryabov.constants;

import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.util.ClassFinder;
import ru.javarush.island.ryabov.util.EntityScanner;

import java.util.List;

public class Constants {
    public static final int ROWS = 30;
    public static final int  COLS = 30;

    public static final List<Class<?>> TYPES = ClassFinder.find("ru.javarush.island.ryabov.entity.organisms.organism");
    public static final Organism[] ORGANISMS = EntityScanner.createPrototypes(TYPES);
}
