package ru.javarush.island.ryabov;

import ru.javarush.island.ryabov.entity.map.GameMap;
import ru.javarush.island.ryabov.util.GameMapCreator;
import ru.javarush.island.ryabov.view.ConsoleStats;

public class Runner {
    public static void main(String[] args) {
        GameMap gameMap = GameMapCreator.createMap();
        ConsoleStats.allStats(gameMap);
    }
}