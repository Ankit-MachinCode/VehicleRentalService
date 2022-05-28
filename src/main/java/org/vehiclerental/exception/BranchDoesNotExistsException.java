package org.vehiclerental.exception;

public class BranchDoesNotExistsException extends RuntimeException {
    public BranchDoesNotExistsException() {
        System.err.println("Branch does not exists exception");
    }
}
