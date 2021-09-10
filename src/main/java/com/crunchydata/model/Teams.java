package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Teams {
    @JsonProperty("teams")
    List<TeamInfo> teamList;

    public List<TeamInfo> getTeamList() {
        return teamList;
    }
}
