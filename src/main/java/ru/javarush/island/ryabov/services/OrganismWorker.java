package ru.javarush.island.ryabov.services;

import ru.javarush.island.ryabov.constants.Constants;
import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.map.GameMap;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class OrganismWorker implements Runnable {
    private final GameMap gameMap;
    private final Queue<Task> tasks = new LinkedBlockingQueue<>();

    public OrganismWorker(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    processOneCell(cell);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("OMG. Debug it!");
                    System.exit(0);
                }
            }
        }
    }

    private synchronized void processOneCell(Cell cell) {
        Constants.DIED.set(0);
        Constants.BORNED.set(0);
        cell.getLock().lock();
        try {
            for (Organism organism : cell.ORGANISMS) {
                tasks.add(new Task(organism, cell));
            }
        } finally {
            cell.getLock().unlock();
        }
        int times = 0;
        for (Task task : tasks) {
            task.doTask();
            tasks.clear();
        }
    }
}