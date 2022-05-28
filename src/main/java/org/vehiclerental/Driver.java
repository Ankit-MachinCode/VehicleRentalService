package org.vehiclerental;

import org.vehiclerental.dao.VehicleType;
import org.vehiclerental.service.BranchService;
import org.vehiclerental.service.IRentalStrategy;
import org.vehiclerental.service.LowestPriceStrategy;
import org.vehiclerental.service.VehicleService;

import java.time.LocalDateTime;
import java.time.Month;

public class Driver {

    public static void main(String[] args) {
        BranchService branchService = new BranchService();
        IRentalStrategy rentalStrategy = new LowestPriceStrategy(branchService.getBranchList());
        VehicleService vehicleService = new VehicleService(branchService);


        branchService.addBranch("Vasanth Vihar");
        branchService.addBranch("Cyber City");
        //branchService.addBranch("Cyber City");

        branchService.allocatePrice("Vasanth Vihar", VehicleType.Sedan, 100);
        branchService.allocatePrice("Vasanth Vihar", VehicleType.Hatchback, 80);
        branchService.allocatePrice("Cyber City", VehicleType.Sedan, 50);
        branchService.allocatePrice("Cyber City", VehicleType.Hatchback, 50);

        vehicleService.addVehicle("DL 01 MR 9310", VehicleType.Sedan,
                "Vasanth Vihar");
        vehicleService.addVehicle("DL 01 MR 9310", VehicleType.Sedan,
                "Vasanth Vihar");
        vehicleService.addVehicle("DL 01 MR 9310", VehicleType.Sedan,
                "Cyber City");
        vehicleService.addVehicle("DL 01 MR 9310", VehicleType.Sedan,
                "ABC");
        vehicleService.addVehicle("DL 01 MR 9311", VehicleType.Sedan,
                "Cyber City");
        vehicleService.addVehicle("DL 01 MR 9312", VehicleType.Hatchback,
                "Cyber City");
        //  29-02-2020 04:00 PM, 29-02-2020 05:00 PM
        rentalStrategy.bookVehicle(VehicleType.Sedan, LocalDateTime.of(2020, Month.FEBRUARY, 29, 4, 00),
                LocalDateTime.of(2020, Month.FEBRUARY, 29, 5, 00));

        rentalStrategy.bookVehicle(VehicleType.Sedan, LocalDateTime.of(2020, Month.FEBRUARY, 29, 6, 00),
                LocalDateTime.of(2020, Month.FEBRUARY, 29, 7, 00));

        rentalStrategy.bookVehicle(VehicleType.Sedan, LocalDateTime.of(2020, Month.FEBRUARY, 29, 4, 00),
                LocalDateTime.of(2020, Month.FEBRUARY, 29, 6, 00));

        rentalStrategy.bookVehicle(VehicleType.Sedan, LocalDateTime.of(2020, Month.FEBRUARY, 29, 4, 00),
                LocalDateTime.of(2020, Month.FEBRUARY, 29, 5, 00));

/*
        rentalStrategy.bookVehicle(VehicleType.Sedan, LocalDateTime.now(), LocalDateTime.now());
        rentalStrategy.bookVehicle(VehicleType.Sedan, LocalDateTime.now(), LocalDateTime.now());
        rentalStrategy.bookVehicle(VehicleType.Sedan, LocalDateTime.now(), LocalDateTime.now());
        rentalStrategy.bookVehicle(VehicleType.Sedan, LocalDateTime.now(), LocalDateTime.now());*/
    }
}
