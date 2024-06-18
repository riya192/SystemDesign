package org.example.command;

import org.example.service.ParkingLotService;

import java.util.List;

public class UnparkCarCommand extends ParkingLotCommandAbstractClass{

    public static final String COMMAND_NAME = "unpark_car";

    UnparkCarCommand(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }


    @Override
    public void execute(List<String> params) {
        int slotId = Integer.parseInt(params.getFirst());
        this.parkingLotService.unParkCar(slotId);
    }
}
