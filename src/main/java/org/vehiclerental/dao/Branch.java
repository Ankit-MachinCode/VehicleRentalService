package org.vehiclerental.dao;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Branch {
    String name;
    Set<Vehicle> vehicleList;
    Set<Price> priceList;

    public Branch(String name) {
        this.name = name;
        vehicleList = new HashSet<>();
        priceList = new HashSet<>();
    }

    public Set<Price> getPriceList() {
        return priceList;
    }

    public String getName() {
        return name;
    }

    public Integer getPriceByVehicleType(VehicleType vehicleType) {
        return priceList.stream()
                .filter(price -> vehicleType.equals(price.getVehicleType()))
                .findFirst()
                .map(Price::getPricePerHour).orElse(Integer.MAX_VALUE);

    }

    public List<Vehicle> getAvaiableVehicleListByVehicleType(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime) {
        return vehicleList.stream()
                .filter(vehicle -> vehicleType.equals(vehicle.getType()))
                .filter(vehicle -> vehicle.getBookedTimeSlot().stream()
                        .filter(timeSlot -> timeSlot.getEndTime().isBefore(startTime)
                                || timeSlot.getStartTime().isAfter(endTime))
                        .collect(Collectors.toList()).isEmpty())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return getName().equals(branch.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public void registerVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

}
