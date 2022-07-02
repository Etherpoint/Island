package ru.javarush.island.ryabov.services;

import ru.javarush.island.ryabov.entity.map.Cell;
import ru.javarush.island.ryabov.entity.map.GameMap;
import ru.javarush.island.ryabov.entity.organisms.types.Organism;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//public class OrganismWorker implements Runnable {
//
//    private final Organism prototype;
//    private final GameMap gameMap;
//    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();
//
//    public OrganismWorker(Organism prototype, GameMap gameMap) {
//        this.prototype = prototype;
//        this.gameMap = gameMap;
//    }
//
//    @Override
//    public void run() {
//        Cell[][] cells = gameMap.getCells();
//        for (Cell[] row : cells) {
//            for (Cell cell : row) {
//                try {
//                    processOneCell(cell);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    System.err.println("OMG. Debug it!");
//                    System.exit(0);
//                }
//            }
//        }
//    }
//
//    private void processOneCell(Cell cell) {
//        String type = prototype.getType();
//        cell.getLock().lock(); //ONLY READ
//        try {
//            organisms.forEach(organism -> {
//                //here possible action-cycle for entity (enum, collection or array)
//                tasks.add(new Task(organism, cell));
//            });
//        } finally {
//            cell.getLock().unlock();
//        }
//        tasks.forEach(Task::doTask);
//        tasks.clear();
//    }
//}