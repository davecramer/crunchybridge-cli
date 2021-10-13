package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Plan extends BaseModel {
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
        StringBuilder sb = new StringBuilder("Plan: ").append("id: ").append(id)
                .append("\nDisplay Name: ").append(displayName)
                .append("\nCPU: ").append(cpu)
                .append("\nMemory: ").append(memory);
        return sb.toString();
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }
}
