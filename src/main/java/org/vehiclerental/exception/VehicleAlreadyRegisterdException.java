package org.vehiclerental.exception;

public class VehicleAlreadyRegisterdException extends RuntimeException {
    public VehicleAlreadyRegisterdException(String licenseNumber) {
        System.err.println("Vehicle already registered with license number " + licenseNumber);
    }
}
