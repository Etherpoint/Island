//package ru.javarush.island.ryabov.view;
//
//import ru.javarush.island.ryabov.entity.map.Cell;
//import ru.javarush.island.ryabov.entity.map.GameMap;
//import ru.javarush.island.ryabov.entity.organisms.types.Organism;
//
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class ConsoleStats {
//    public static void allStats(GameMap gameMap) {
//        Cell[][] cells = gameMap.getCells();
//        StringBuilder text = new StringBuilder();
//        int row = 0;
//        for (Cell[] rows : cells) {
//            int col = 0;
//            for (Cell cols : rows) {
//                for (Map.Entry<Organism, Integer> organismIntegerEntry : cols.CELL_POPULATION.entrySet()) {
//                    text.append(toList(organismIntegerEntry.getKey()) + ": " + organismIntegerEntry.getValue() + " ");
//                }
//                System.out.println("Cell[" + row + "]" + "[" + col + "]---------" + text);
//                text.delete(0, text.length());
//                col++;
//            }
//            row++;
//        }
//    }
//
//    public static String toList(Organism organism) {
//        String text = organism.toString();
//        Pattern pattern = Pattern.compile("[A-Z].+@");
//        Matcher matcher = pattern.matcher(text);
//        while (matcher.find()) {
//            text = text.substring(matcher.start(), (matcher.end()) - 1);
//        }
//        return text;
//    }
//}
