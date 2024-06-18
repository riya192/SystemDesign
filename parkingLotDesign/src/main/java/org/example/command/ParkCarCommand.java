package org.example.command;

import org.example.module.Car;
import org.example.service.ParkingLotService;

import java.util.List;

public class ParkCarCommand extends ParkingLotCommandAbstractClass{

    public static final String COMMAND_NAME = "park_car";

    ParkCarCommand(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public void execute(List<String> params) {
        String regNo = params.getFirst();
        String colour = params.getLast();
        this.parkingLotService.parkCar(new Car(regNo, colour));
    }
}
