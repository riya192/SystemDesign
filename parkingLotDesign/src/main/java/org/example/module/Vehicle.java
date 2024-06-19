package org.example.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Vehicle {

     String registrationNumber;
     String colour;

    abstract int getParkingFees();

}
