package org.vehiclerental.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehicle {
    private String vehicleNumber;
    private VehicleType type;

    private List<TimeSlot> bookedTimeSlot;

    public Vehicle(String vehicleNumber, VehicleType type) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        bookedTimeSlot = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleNumber.equals(vehicle.vehicleNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNumber);
    }

    public VehicleType getType() {
        return type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public List<TimeSlot> getBookedTimeSlot() {
        return bookedTimeSlot;
    }

    public void updatedBookTimeSlot(TimeSlot timeSlot) {
        bookedTimeSlot.add(timeSlot);
    }
}
