package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FireWallRules {
    @JsonProperty("firewall_rules")
    List<FireWall> rules;

    public List<FireWall> getRules() {
        return rules;
    }
}
