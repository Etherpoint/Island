package ru.javarush.island.ryabov.view;

import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.map.GameMap;

public class ConsoleStats {
    public static void allStats(GameMap gameMap){
        for (Cell[] row : gameMap.getCells()) {
            for (Cell cell : row) {
                System.out.println(cell.CELL_POPULATION.entrySet());
            }
        }
    }
}
