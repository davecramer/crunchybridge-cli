package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Provider {
    private final String id;
    @JsonProperty("display_name")
    private final String displayName;
    private final List<Region> regions;
    private final List<Plan> plans;

    public Provider(String id, String displayName, List<Region> regions, List<Plan> plans) {
        this.id = id;
        this.displayName = displayName;
        this.regions = regions;
        this.plans = plans;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", regions=" + regions +
                ", plans=" + plans +
                '}';
    }
}
