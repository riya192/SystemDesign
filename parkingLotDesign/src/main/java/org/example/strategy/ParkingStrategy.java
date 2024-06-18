package org.example.strategy;

import org.example.module.ParkingLot;

public interface ParkingStrategy {

    public int getNextAvailableSlot();

    public void addSlot(int id);

    public void removeSlot(int id);

    public void initialize(int capacity);

}

