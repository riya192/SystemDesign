package org.example.command;

import org.example.module.Car;
import org.example.module.Vehicle;
import org.example.module.VehicleFactory;
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
        String vehicleType = params.get(1);
        this.parkingLotService.parkCar(VehicleFactory.getInstance(vehicleType, regNo, colour));
    }
}
