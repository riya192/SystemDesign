package org.example.module;

import org.example.exception.VehicleNotSupported;

public class VehicleFactory {
    public static Vehicle getInstance(String vehicleType, String regNo, String color)
    {
        try{
            if(vehicleType.equals("Car")) return new Car(regNo, color);
            throw new VehicleNotSupported();
        }
        catch (VehicleNotSupported ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
