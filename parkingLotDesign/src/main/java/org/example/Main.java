package org.example;

import org.example.command.*;
import org.example.module.Command;
import org.example.service.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ParkingLotService parkingLotService = new ParkingLotService();

        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);

        List<Command> commandsToExecute = new ArrayList<>();
        commandsToExecute.add(new Command(CreateParkingLotCommand.COMMAND_NAME, List.of("6", "LeastAvailableParkingStrategy")));
        commandsToExecute.add(new Command(ParkCarCommand.COMMAND_NAME, List.of("KA01", "Car", "White")));
        commandsToExecute.add(new Command(ParkCarCommand.COMMAND_NAME, List.of("KA02", "Car", "White")));
        commandsToExecute.add(new Command(ParkCarCommand.COMMAND_NAME, List.of("KA04", "Car", "Black")));
        commandsToExecute.add( new Command(StatusCommand.COMMAND_NAME, List.of()));
        commandsToExecute.add(new Command(UnparkCarCommand.COMMAND_NAME, List.of("8")));
        commandsToExecute.add(new Command(UnparkCarCommand.COMMAND_NAME, List.of("5")));
        commandsToExecute.add(new Command(UnparkCarCommand.COMMAND_NAME, List.of("1")));
        commandsToExecute.add( new Command(StatusCommand.COMMAND_NAME, List.of()));
        commandsToExecute.add( new Command(ParkCarCommand.COMMAND_NAME, List.of("KA03", "Car", "Red")));
        commandsToExecute.add( new Command(StatusCommand.COMMAND_NAME, List.of()));
        commandsToExecute.add( new Command(ParkCarCommand.COMMAND_NAME, List.of("KA05", "Car", "Red")));
        commandsToExecute.add( new Command(ParkCarCommand.COMMAND_NAME, List.of("KA06", "Car", "Red")));
        commandsToExecute.add( new Command(ParkCarCommand.COMMAND_NAME, List.of("KA07", "Car", "Brown")));
        commandsToExecute.add( new Command(StatusCommand.COMMAND_NAME, List.of()));
        commandsToExecute.add( new Command(ParkCarCommand.COMMAND_NAME, List.of("KA08", "Car", "Brown")));
        commandsToExecute.add( new Command(ParkCarCommand.COMMAND_NAME, List.of("KA08", "Truck", "Brown")));
        commandsToExecute.add(new Command(GetAllRegNoForThisColourCommand.COMMAND_NAME, List.of("Red")));
        commandsToExecute.add( new Command(GetAllSlotIdForThisColouCommand.COMMAND_NAME, List.of("Red")));

        for(Command command : commandsToExecute)
        {
            System.out.println(command);
            ParkingLotCommandAbstractClass commandClass = commandExecutorFactory.getParkingLotCommand(command.getCommandName());
            commandClass.execute(command.getParams());
        }
    }
}