package org.vehiclerental.exception;

public class BranchAlreadyExistsException extends RuntimeException {
    public BranchAlreadyExistsException(String branch) {
        System.err.println("Branch already exists with Name " + branch);
    }
}
