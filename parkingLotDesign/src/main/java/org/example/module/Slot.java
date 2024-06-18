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
    private Car assignedCar;
    public Slot(int slotId) {
        this.slotId = slotId;
        this.assignedCar = null;
    }
    public boolean isSlotEmpty()
    {
        return assignedCar == null;
    }

    public boolean isSlotFull()
    {
        return !isSlotEmpty();
    }

    public void makeSlotEmpty()
    {
        this.setAssignedCar(null);
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
        return assignedCar == null ? "null" : assignedCar.toString();
    }
}
