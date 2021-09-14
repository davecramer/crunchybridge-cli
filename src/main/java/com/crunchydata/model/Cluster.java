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
public class Cluster extends BaseModel {
    @JsonProperty("team_id")
    private String teamId;
    @JsonProperty("provider_id")
    private String providerId;
    @JsonProperty("region_id")
    private String regionId;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("updated_id")
    private Timestamp updatedAt;
    @JsonProperty("name")
    private String name;
    @JsonProperty("major_version")
    private Integer majorVersion;
    @JsonProperty("storage")
    private Integer storage;
    private Integer cpu;
    private Integer memory;
    @JsonProperty("is_ha")
    private boolean isHa;

    @JsonProperty("plan_id")
    private String plan;

    private List<Cluster> replicas;

    public Cluster() {

    }
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

    public void setId(String id) {
        this.id = id;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajorVersion(Integer majorVersion) {
        this.majorVersion = majorVersion;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public void setHa(boolean ha) {
        isHa = ha;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getId() {
        return id;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getRegionId() {
        return regionId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public String getName() {
        return name;
    }

    public Integer getMajorVersion() {
        return majorVersion;
    }

    public Integer getStorage() {
        return storage;
    }

    public Integer getCpu() {
        return cpu;
    }

    public Integer getMemory() {
        return memory;
    }

    public boolean isHa() {
        return isHa;
    }

    public String getPlan() {
        return plan;
    }

    public List<Cluster> getReplicas() {
        return replicas;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Cluster: ").append("id: ").append(id)
                .append("\n Name: ").append(name)
                .append("\nTeam Id: ").append(teamId)
                .append("\nProvider Id: ").append(providerId)
                .append("\nRegion Id: ").append(regionId)
                .append("\nCreated At: ").append(createdAt)
                .append("\n Updated At: ").append(updatedAt)
                .append("\n Major Version: ").append(majorVersion)
                .append("\n Storage: ").append(storage)
                .append("\n CPU: ").append(cpu)
                .append("\n Is HA: ").append(isHa);
        return sb.toString();
    }
}
