package org.vehiclerental.service;

import org.vehiclerental.dao.Branch;
import org.vehiclerental.dao.TimeSlot;
import org.vehiclerental.dao.Vehicle;
import org.vehiclerental.dao.VehicleType;
import org.vehiclerental.exception.VehicleNotFoundException;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class LowestPriceStrategy implements IRentalStrategy {
    Set<Branch> branchList;

    public LowestPriceStrategy(Set<Branch> branchList) {
        this.branchList = branchList;
    }

    @Override
    public void bookVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime) {
        try {
            Optional<Vehicle> vehicle = branchList.stream()
                    .sorted(Comparator.comparingInt(branch -> branch.getPriceByVehicleType(vehicleType)))
                    .filter(branch -> branch.getAvaiableVehicleListByVehicleType(vehicleType, startTime, endTime).size() > 0)
                    .map(branch -> branch.getAvaiableVehicleListByVehicleType(vehicleType, startTime, endTime).get(0)).findFirst();
            if (vehicle.isPresent()) {
                vehicle.get().updatedBookTimeSlot(new TimeSlot(startTime, endTime));
                System.out.println(vehicle.get().getVehicleNumber() + " Booked");
            } else {
                throw new VehicleNotFoundException();
            }
        } catch (Exception e) {

        }
    }
}
