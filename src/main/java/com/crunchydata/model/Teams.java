package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Teams {
    @JsonProperty("teams")
    List<Team> teamList;

    public List<Team> getTeamList() {
        return teamList;
    }
}
