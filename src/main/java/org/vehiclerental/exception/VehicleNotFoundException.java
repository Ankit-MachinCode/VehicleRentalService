package org.vehiclerental.exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException() {
        System.err.println("Vehicle not found exception");
    }
}
