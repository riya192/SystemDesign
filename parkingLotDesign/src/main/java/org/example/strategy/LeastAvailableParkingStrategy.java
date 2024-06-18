package org.example.strategy;

import org.example.exception.ParkingSlotFullException;
import org.example.module.ParkingLot;
import org.example.module.Slot;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class LeastAvailableParkingStrategy implements ParkingStrategy{

    private TreeSet<Integer> treeSet;
    public LeastAvailableParkingStrategy()
    {
        this.treeSet = new TreeSet<>();
    }


    @Override
    public int getNextAvailableSlot() {
        if(treeSet.isEmpty()) throw new ParkingSlotFullException();
        return this.treeSet.first();
    }

    @Override
    public void addSlot(int id) {
        this.treeSet.add(id);
    }

    @Override
    public void removeSlot(int id) {
        this.treeSet.remove(id);
    }

    @Override
    public void initialize(int capacity) {
        for (int i = 1; i <=capacity; i++) {
            this.treeSet.add(i);
        }
    }

}
