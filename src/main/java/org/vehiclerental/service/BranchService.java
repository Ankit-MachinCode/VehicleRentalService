package org.vehiclerental.service;

import org.vehiclerental.dao.Branch;
import org.vehiclerental.dao.Price;
import org.vehiclerental.dao.VehicleType;
import org.vehiclerental.exception.BranchAlreadyExistsException;
import org.vehiclerental.exception.BranchDoesNotExistsException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BranchService {
    Set<Branch> branchList;

    public BranchService() {
        this.branchList = new HashSet<>();
    }

    public void addBranch(String branchName) {
        try {
            Branch branch = new Branch(branchName);
            if (branchList.contains(branch)) {
                throw new BranchAlreadyExistsException(branchName);
            } else {
                branchList.add(branch);
            }
            System.out.println("Created new Branch " + branchName);
        } catch (Exception e) {

        }
    }

    Optional<Branch> getBranch(String branchName) {
        return this.branchList.stream()
                .filter(branch1 -> branchName.equalsIgnoreCase(branch1.getName())).findAny();
    }

    public void allocatePrice(String branchName, VehicleType type, int ratePerHour) {
        try {
            Optional<Branch> branchOptional = getBranch(branchName);
            Branch branch = branchOptional.orElseThrow(BranchDoesNotExistsException::new);
            branch.getPriceList();
            Optional<Price> priceOptional = branch.getPriceList().stream()
                    .filter(price -> price.getVehicleType().equals(type)).findAny();

            if (priceOptional.isPresent()) {
                priceOptional.get().setPricePerHour(ratePerHour);
            } else {
                branch.getPriceList().add(new Price(type, ratePerHour));
            }
            System.out.println("Allocated Pricing for Vehicle Type" + type + " to Branch " + branchName);
        } catch (Exception e) {

        }
    }


    public Set<Branch> getBranchList() {
        return branchList;
    }
}
