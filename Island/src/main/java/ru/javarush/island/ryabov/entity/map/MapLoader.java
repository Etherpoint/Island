package ru.javarush.island.ryabov.entity.map;

import ru.javarush.island.ryabov.constants.Constants;

public class MapLoader {
    GameMap gameMap = new GameMap(Constants.ROWS, Constants.COLS);
    Cell[][] cells = gameMap.getCells();
}
