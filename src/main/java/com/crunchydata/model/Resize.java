package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resize {

    @JsonProperty("plan_id")
    String planId;
    Integer storage;

    public String getPlanId() {
        return planId;
    }

    public Integer getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return "Resize: " +
                "\nPlanId: " + planId  +
                "\nStorage=" + storage ;
    }
}
