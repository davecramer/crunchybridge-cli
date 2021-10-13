package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Clusters {
    @JsonProperty("clusters")
    List<Cluster> clusterList;

    public Clusters() {}

    public Clusters(List<Cluster> clusterList) {
        this.clusterList = clusterList;
    }

    public List<Cluster> getClusterList() {
        return clusterList;
    }

    public void setClusterList(List<Cluster> clusterList) {
        this.clusterList = clusterList;
    }
}
