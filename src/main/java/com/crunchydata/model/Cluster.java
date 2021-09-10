package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

/*
"id": "uan5fhajlzhjdnzmhgfp2d2umy",
        "team_id": "yqdhoxeognh67gby7wag7w5gem",
        "provider_id": "aws",
        "region_id": "us-east-1",
        "created_at": "2021-01-22T22:22:35.03991Z",
        "updated_at": "2021-01-22T22:22:35.03991Z",
        "name": "test-1",
        "major_version": 12,
        "storage": 100,
        "cpu": 2,
        "memory": 8,
        "is_ha": true
 */
public class Cluster {
    private final String id;
    @JsonProperty("team_id")
    private final String teamId;
    @JsonProperty("provider_id")
    private final String providerId;
    @JsonProperty("region_id")
    private final String regionId;
    @JsonProperty("created_at")
    private final Timestamp createdAt;
    @JsonProperty("updated_id")
    private final Timestamp updatedAt;
    private final String name;
    @JsonProperty("major_version")
    private final Integer majorVersion;
    private final Integer storage;
    private final Integer cpu;
    private final Integer memory;
    @JsonProperty("is_ha")
    private final boolean isHa;

    private final List<Cluster> replicas;

    public Cluster(String id, String teamId, String providerId, String regionId,
                   Timestamp createdAt, Timestamp updatedAt, String name,
                   Integer majorVersion, Integer storage, Integer cpu,
                   Integer memory, boolean isHa, List<Cluster> replicas) {
        this.id = id;
        this.teamId = teamId;
        this.providerId = providerId;
        this.regionId = regionId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.majorVersion = majorVersion;
        this.storage = storage;
        this.cpu = cpu;
        this.memory = memory;
        this.isHa = isHa;
        this.replicas = replicas;
    }
    public String toString() {
        return "Cluster{" +
                "id='" + id + '\'' +
                ", teamId='" + teamId + '\'' +
                ", providerId='" + providerId + '\'' +
                ", regionId='" + regionId + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", name='" + name + '\'' +
                ", majorVersion=" + majorVersion +
                ", storage=" + storage +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", ha=" + isHa +
                '}';
    }
}
