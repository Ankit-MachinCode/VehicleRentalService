package org.vehiclerental.service;

import org.vehiclerental.dao.VehicleType;

import java.time.LocalDateTime;

public interface IRentalStrategy {
    void bookVehicle(VehicleType vehicleType, LocalDateTime startTime, LocalDateTime endTime);
}
