package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Clusters {
    @JsonProperty("clusters")
    List<Cluster> clusterList;

    public List<Cluster> getClusterList() {
        return clusterList;
    }
}
