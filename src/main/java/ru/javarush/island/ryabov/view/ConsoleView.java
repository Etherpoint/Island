package ru.javarush.island.ryabov.view;

import ru.javarush.island.ryabov.config.Setting;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.map.GameMap;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@SuppressWarnings("FieldCanBeLocal")
public class ConsoleView implements View {

    private final GameMap gameMap;
    private final int cellWidth = Setting.get().getConsoleCellWith();

    public ConsoleView(GameMap gameMap) {
        this.gameMap = gameMap;
    }


    @Override
    public void showStatistics() {
        Map<String, Double> rawStatistics = new HashMap<>();
        Map<String, Long> statistics = new HashMap<>();
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.ORGANISMS.forEach(organisms -> {
                    String icon = organisms.getIcon();
                    int count = organisms.calculateSize(cell);
                    rawStatistics.put(icon, rawStatistics.getOrDefault(icon, 0D) + count);
                });
                }
            }
        rawStatistics.forEach((key, value) -> statistics.put(key, Math.round(value)));
        System.out.println(statistics + "\n");
        statistics.toString();
    }
    @Override
    public void allStats(GameMap gameMap) {
        Cell[][] cells = gameMap.getCells();
        StringBuilder text = new StringBuilder();
        int row = 0;
        for (Cell[] rows : cells) {
            int col = 0;
            for (Cell cols : rows) {
                for (Map.Entry<Organism, Integer> organismIntegerEntry : cols.CELL_POPULATION.entrySet()) {
                    text.append(toList(organismIntegerEntry.getKey())).append(": ").append(organismIntegerEntry.getValue()).append(" ");
                }
                System.out.println("Cell[" + row + "]" + "[" + col + "]---------" + text);
                text.delete(0, text.length());
                col++;
            }
            row++;
        }
    }

    public static String toList(Organism organism) {
        String text = organism.toString();
        Pattern pattern = Pattern.compile("[A-Z].+@");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            text = text.substring(matcher.start(), (matcher.end()) - 1);
        }
        return text;
    }
}