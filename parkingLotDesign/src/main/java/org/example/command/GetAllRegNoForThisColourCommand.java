package org.example.command;

import org.example.service.ParkingLotService;

import java.util.List;

public class GetAllRegNoForThisColourCommand extends ParkingLotCommandAbstractClass{

    public static final String COMMAND_NAME ="get_all_reg_no_for_this_command";
    GetAllRegNoForThisColourCommand(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public void execute(List<String> params) {
        String colour = params.getFirst();
        List<String> regNoForColor = this.parkingLotService.getRegNoForColor(colour);
        regNoForColor.forEach(System.out::println);
    }
}
