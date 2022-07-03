package ru.javarush.island.ryabov.view;

import ru.javarush.island.ryabov.config.Setting;
import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.map.GameMap;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;
import ru.javarush.island.ryabov.util.CellCreator;

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
        for (int rows = 0; rows < Constants.SHOWROWS; rows++) {
            int col = 1;
            for (int cols = 0; cols < Constants.SHOWCOLS; cols++) {
                Map<String, Long> cellStatistic = new HashMap<>();
                for (Organism organismIntegerEntry : cells[rows][cols].CELL_POPULATION) {
                    String icon = organismIntegerEntry.getIcon();
                    int count = organismIntegerEntry.calculateSize(cells[rows][cols]);
                    cellStatistic.put(icon, cellStatistic.getOrDefault(icon, (long) count));
                }
                System.out.println("Cell[" + row + "]" + "[" + col + "]---------" + cellStatistic);
                col++;
            }
            row++;
        }
        System.out.println("EATEN: " + Constants.EATEN.get());
        System.out.println("BORNED: " + Constants.BORNED.get());
        System.out.println("DIED: " + Constants.DIED.get());
        System.out.println("\n");
    }
}