package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Provider extends BaseModel{

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
        StringBuilder sb = new StringBuilder("Provider: ").append("id: ").append(id)
                .append("\nDisplay Name: ").append(displayName)
                .append("\nRegions: ").append(regions)
                .append("\nPlans").append(plans);
        return sb.toString();
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public List<Plan> getPlans() {
        return plans;
    }
}
