package org.example.command;

import org.example.service.ParkingLotService;
import org.example.strategy.LeastAvailableParkingStrategy;

import java.util.List;

public class StatusCommand extends ParkingLotCommandAbstractClass{

    public static final String COMMAND_NAME = "parking_lot_status";

    StatusCommand(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public void execute(List<String> params) {
        this.parkingLotService.printParkingLotStatus();
    }
}
