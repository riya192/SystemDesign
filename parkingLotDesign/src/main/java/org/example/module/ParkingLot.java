package org.example.module;

import lombok.Getter;
import lombok.Setter;
import org.example.exception.InvalidSlotNumberException;
import org.example.exception.ParkingLotNotCreatedException;
import org.example.exception.SlotAlreadyEmptyException;
import org.example.exception.SlotOccupiedException;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class ParkingLot {
    private int capacity;
    private Map<Integer, Slot> parkingLot;
    public ParkingLot(int capacity)
    {
        this.capacity = capacity;
        parkingLot = new HashMap<>();
        for (int i = 1; i <=capacity; i++) {
            parkingLot.put(i, new Slot(i));
        }
    }
    public void parkCar(Vehicle vehicle, int slotId)
    {
        if(validateSlotId(slotId)) throw new InvalidSlotNumberException();
        if(verifyIfSlotAlreadyOccupied(slotId)) throw new SlotOccupiedException();
        parkingLot.get(slotId).setAssiggnedVehicle(vehicle);
    }

    public void unParkCar(int slotId)
    {
        if(validateSlotId(slotId)) throw new InvalidSlotNumberException();
        if(parkingLot.get(slotId).isSlotEmpty()) throw new SlotAlreadyEmptyException();
        parkingLot.get(slotId).makeSlotEmpty();
    }

    public List<Slot> getAllAssignedSlots()
    {
        if(parkingLot == null || parkingLot.isEmpty()) throw new ParkingLotNotCreatedException();
        return parkingLot.values().stream().filter(Slot::isSlotFull).collect(Collectors.toList());
    }

    private boolean validateSlotId(int id)
    {
        return id > getCapacity();
    }

    private boolean verifyIfSlotAlreadyOccupied(int id)
    {
        return !(parkingLot.get(id).getAssiggnedVehicle() == null);
    }

    public boolean isParkingLotFull()
    {
        return parkingLot.values().stream().anyMatch(Slot::isSlotEmpty);
    }
}
