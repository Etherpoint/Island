package ru.javarush.island.ryabov.util;
import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;

public class CellCreator {
    public static Cell createCell(){
        Cell cell = new Cell();
        for (Organism organism : Constants.ORGANISMS) {
            cell.CELL_POPULATION.put(organism, 5);
        }
        return cell;
    }
}
