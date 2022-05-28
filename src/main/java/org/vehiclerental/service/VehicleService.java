package org.vehiclerental.service;

import org.vehiclerental.dao.Branch;
import org.vehiclerental.dao.Vehicle;
import org.vehiclerental.dao.VehicleType;
import org.vehiclerental.exception.BranchDoesNotExistsException;
import org.vehiclerental.exception.VehicleAlreadyRegisterdException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class VehicleService {

    Set<Vehicle> vehicleList;

    BranchService branchService;

    public VehicleService(BranchService branchService) {
        this.branchService = branchService;
        this.vehicleList = new HashSet<>();
    }

    public void addVehicle(String licenseNumber, VehicleType type, String branchName) {
        try {
            Optional<Branch> branchOptional = branchService.getBranch(branchName);
            Branch branch = branchOptional.orElseThrow(BranchDoesNotExistsException::new);
            Vehicle vehicle = new Vehicle(licenseNumber, type);
            if (vehicleList.contains(vehicle)) {
                throw new VehicleAlreadyRegisterdException(licenseNumber);
            } else {
                vehicleList.add(vehicle);
                branch.registerVehicle(vehicle);
            }
            System.out.println("Added Vehicle " + licenseNumber + " to Branch " + branchName);
        } catch (Exception e) {
//Log Errors
        }
    }

}
