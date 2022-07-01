package ru.javarush.island.ryabov.util;

import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.map.GameMap;

public class GameMapCreator {
    public static GameMap createMap() {
        GameMap gameMap = new GameMap(Constants.ROWS, Constants.COLS);
        Cell[][] cells = gameMap.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                cells[row][col] = CellCreator.createCell();
            }
        }
        return gameMap;
    }
}
