package org.example.command;

import org.example.exception.InvalidCommandException;
import org.example.service.ParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<String, ParkingLotCommandAbstractClass> commandMap;

    public CommandExecutorFactory(ParkingLotService parkingLotService)
    {
        commandMap = new HashMap<>();
        commandMap.put(
                CreateParkingLotCommand.COMMAND_NAME,
                new CreateParkingLotCommand(parkingLotService)
        );commandMap.put(
                ParkCarCommand.COMMAND_NAME,
                new ParkCarCommand(parkingLotService)
        );commandMap.put(
                UnparkCarCommand.COMMAND_NAME,
                new UnparkCarCommand(parkingLotService)
        );commandMap.put(
                StatusCommand.COMMAND_NAME,
                new StatusCommand(parkingLotService)
        );commandMap.put(
                GetAllSlotIdForThisColouCommand.COMMAND_NAME,
                new GetAllSlotIdForThisColouCommand(parkingLotService)
        );commandMap.put(
                GetAllRegNoForThisColourCommand.COMMAND_NAME,
                new GetAllRegNoForThisColourCommand(parkingLotService)
        );
    }

    public ParkingLotCommandAbstractClass getParkingLotCommand(String commandName)
    {
        if(!commandMap.containsKey(commandName))
        {
            throw new InvalidCommandException();
        }
        return commandMap.get(commandName);
    }
}
