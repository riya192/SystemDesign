package org.example.service;

import lombok.Setter;
import org.example.exception.*;
import org.example.module.Car;
import org.example.module.ParkingLot;
import org.example.module.Slot;
import org.example.strategy.ParkingStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Setter
public class ParkingLotService {
    private ParkingStrategy parkingStrategy;
    private ParkingLot parkingLot;

    public void createParkingLot(int capacity, ParkingStrategy parkingStrategy)
    {
        if(this.parkingLot != null) throw new ParkingLotAlreadyExistException();
        this.parkingLot = new ParkingLot(capacity);
        this.parkingStrategy = parkingStrategy;
        parkingStrategy.initialize(capacity);
    }

    public void parkCar(Car car)
    {
        try {
            int nextClosestAvailableSlot = this.parkingStrategy.getNextAvailableSlot();
            parkingLot.parkCar(car, nextClosestAvailableSlot);
            parkingStrategy.removeSlot(nextClosestAvailableSlot);

        }catch (ParkingSlotFullException ex)
        {
            System.out.println(ex.getMessage());
        }catch (SlotOccupiedException ex)
        {
            System.out.println(ex.getMessage());
        }catch (InvalidSlotNumberException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void unParkCar(int slotId)
    {
        try{
            this.parkingLot.unParkCar(slotId);
            this.parkingStrategy.addSlot(slotId);
        }catch (InvalidSlotNumberException ex)
        {
            System.out.println(ex.getMessage());
        }catch (SlotAlreadyEmptyException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public List<String> getRegNoForColor(String expectedColour)
    {
        return getSlotsForAColour(expectedColour)
                    .stream()
                    .map(slot -> slot.getAssignedCar().getRegistrationNumber())
                    .collect(Collectors.toList());
    }

    public List<Integer> getSlotIdsOccupiedByAFixColourCar(String expectedColour)
    {
        return getSlotsForAColour(expectedColour)
                .stream()
                .map(Slot::getSlotId)
                .collect(Collectors.toList());
    }

    public Integer getSlotNumberForRegNumber(String regNumber)
    {
        try{
            return parkingLot.getAllAssignedSlots()
                    .stream()
                    .filter(slot -> slot.getAssignedCar().getRegistrationNumber().equals(regNumber))
                    .findAny().orElseThrow(CarNotFoundException::new).getSlotId();
        }catch (ParkingLotNotCreatedException ex)
        {
            System.out.println(ex.getMessage());
            return -1;
        }
    }

    private List<Slot> getSlotsForAColour(String expectedColour)
    {
        try{
            return parkingLot.getAllAssignedSlots()
                    .stream()
                    .filter(slot -> slot.getAssignedCar().getColour().equals(expectedColour))
                    .collect(Collectors.toList());
        }catch (ParkingLotNotCreatedException ex)
        {
            System.out.println(ex.getMessage());
            return List.of();
        }
    }

    public void printParkingLotStatus()
    {
//        for(Map.Entry<Integer, Slot> entry : this.parkingLot.getParkingLot().entrySet())
//        {
//            System.out.println("Parking slot id -" + entry.getKey() + " has car - " + entry.getValue().toString());
//        }
        this.parkingLot.getParkingLot().entrySet().forEach(System.out::println);
    }

}
