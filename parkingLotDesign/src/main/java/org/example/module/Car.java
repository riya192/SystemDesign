package org.example.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Car  extends Vehicle{
    public Car(String registrationNumber, String colour) {
        super(registrationNumber, colour);
    }
    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
    @Override
    int getParkingFees() {
        return 40;
    }

    public static Car getCarInstance (String regNo, String colour)
    {
        return new Car(regNo, colour);
    }
}
