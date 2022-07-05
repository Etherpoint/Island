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
        System.out.println("\n");
        Cell[][] cells = gameMap.getCells();
        String cellIcon = "";
        int maxOrganism = 0;
        StringBuilder statistics = new StringBuilder();
        for (int rows = 0; rows < Constants.SHOWROWS; rows++) {
            for (int cols = 0; cols < Constants.SHOWCOLS; cols++) {
                for (Organism organismIntegerEntry : cells[rows][cols].CELL_POPULATION) {
                    String icon = organismIntegerEntry.getIcon();
                    int count = organismIntegerEntry.calculateSize(cells[rows][cols]);
                    if (count > maxOrganism) {
                        maxOrganism = count;
                        cellIcon = icon;
                    }
                }
                statistics.append("[").append(cellIcon).append("]");
            }
            System.out.println(statistics);
            statistics.delete(0, statistics.length());
        }
        System.out.println("EATEN: " + Constants.EATEN.get());
        System.out.println("BORNED: " + Constants.BORNED.get());
        System.out.println("DIED: " + Constants.DIED.get());
    }
}