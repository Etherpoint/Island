package ru.javarush.island.ryabov.view;

import ru.javarush.island.ryabov.config.Setting;
import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.map.GameMap;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;

import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("FieldCanBeLocal")
public class ConsoleView implements View {

    private final GameMap gameMap;
    @SuppressWarnings("unused")
    private final int cellWidth = Setting.get().getConsoleCellWith();

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    @Override
    public void showStatistics() {
        Cell[][] cells = gameMap.getCells();
        int row = 1;
        for (Cell[] rows : cells) {
            int col = 1;
            for (Cell cell : rows) {
                Map<String, Long> cellStatistic = new HashMap<>();
                for (Organism organismIntegerEntry : cell.CELL_POPULATION) {
                    String icon = organismIntegerEntry.getIcon();
                    int count = organismIntegerEntry.calculateSize(cell);
                    cellStatistic.put(icon, cellStatistic.getOrDefault(icon, (long) count));
                }
                System.out.println("Cell[" + row + "]" + "[" + col + "]---------" +cellStatistic);
                col++;
            }
            row++;
        }
        System.out.println("EATEN: "+ Constants.EATEN.get());
        System.out.println("BORNED: "+ Constants.BORNED.get());
        System.out.println("DIED: "+ Constants.DIED.get());
        System.out.println("\n");
    }
}