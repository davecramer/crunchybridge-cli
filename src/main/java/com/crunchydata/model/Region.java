package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Region  extends  BaseModel{
    @JsonProperty("display_name")
    private final String displayName;
    private final String location;

    public Region( String id, String displayName, String location ){
        this.id = id;
        this.displayName = displayName;
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Provider: ").append("id: ").append(id)
                .append("\nDisplay Name").append(displayName)
                .append("\nLocation").append(location);
        return sb.toString();
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLocation() {
        return location;
    }
}
