package org.example.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    private int slotId;
    private Vehicle assiggnedVehicle;
    public Slot(int slotId) {
        this.slotId = slotId;
        this.assiggnedVehicle = null;
    }
    public boolean isSlotEmpty()
    {
        return assiggnedVehicle == null;
    }

    public boolean isSlotFull()
    {
        return !isSlotEmpty();
    }

    public void makeSlotEmpty()
    {
        this.setAssiggnedVehicle(null);
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", assignedCar=" + getAssignedCarInfo() +
                '}';
    }

    private String getAssignedCarInfo()
    {
        return assiggnedVehicle == null ? "null" : assiggnedVehicle.toString();
    }
}
