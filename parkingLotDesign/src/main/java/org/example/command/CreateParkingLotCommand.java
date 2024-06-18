package org.example.command;

import org.example.service.ParkingLotService;
import org.example.strategy.LeastAvailableParkingStrategy;

import java.util.List;

public class CreateParkingLotCommand extends ParkingLotCommandAbstractClass{

    public static final String COMMAND_NAME = "create_parking_lot";

    CreateParkingLotCommand(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public void execute(List<String> params) {
        int capacity = Integer.parseInt(params.get(0));
        String parkingStrategy = params.get(1); // can be used to call parking strategy factory class if available
        this.parkingLotService.createParkingLot(capacity, new LeastAvailableParkingStrategy());
    }
}
