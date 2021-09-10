package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Region {
    private final String id;
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
        return "Region{" +
                "id='" + id + '\'' +
                ", displayName='" + displayName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
