package org.example.command;

import org.example.service.ParkingLotService;

import java.util.List;

public class GetAllSlotIdForThisColouCommand extends ParkingLotCommandAbstractClass{

    public static final String COMMAND_NAME = "get_slot_ids_for_colour";
    GetAllSlotIdForThisColouCommand(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public void execute(List<String> params) {
        String colourName = params.getFirst();
        List<Integer> slotIdsOccupiedByAFixColourCar = this.parkingLotService.getSlotIdsOccupiedByAFixColourCar(colourName);
        slotIdsOccupiedByAFixColourCar.forEach(System.out::println);
    }
}
