package org.example.command;

import org.example.service.ParkingLotService;

import java.util.List;

public abstract class ParkingLotCommandAbstractClass
{
    protected ParkingLotService parkingLotService;

    ParkingLotCommandAbstractClass(ParkingLotService parkingLotService)
    {
        this.parkingLotService = parkingLotService;
    }

     public abstract void execute(List<String> params);

}
