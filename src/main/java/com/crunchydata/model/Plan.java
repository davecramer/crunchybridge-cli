package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Plan {
    private final String id;
    @JsonProperty("display_name")
    private final String displayName;
    private final int cpu;
    private final int memory;

    public Plan( String id, String displayName, int cpu, int memory){
        this.id = id;
        this.displayName = displayName;
        this.cpu = cpu;
        this.memory = memory;
    }
    @Override
    public String toString() {
        return "Plan{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                '}';
    }
}
