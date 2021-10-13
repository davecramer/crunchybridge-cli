package com.crunchydata.model;

public class ResizeStatus {
    String status;

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ResizeStatus: " +
                "\nStatus=" + status ;
    }
}
