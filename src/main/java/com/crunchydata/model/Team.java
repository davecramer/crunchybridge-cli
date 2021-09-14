package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Team  extends BaseModel{

    private final String name;
    @JsonProperty("is_personal")
    private final boolean isPersonal;
    private final List<Integer> roles;
    @JsonProperty("created_at")
    private final String createdAt;
    @JsonProperty("updated_at")
    private final String updatedAt;

    private Team(String id, String name, boolean isPersonal, List<Integer> roles, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.isPersonal = isPersonal;
        this.roles = roles;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    private List<String>rolesAsString(){
        List<String> roleList = new ArrayList<String>();
        if (roles != null) {
            for (int role : roles) {
                switch (role) {
                    case 0:
                        roleList.add("Member");
                        break;
                    case 1:
                        roleList.add("Manager");
                        break;
                    case 2:
                        roleList.add("Administrator");
                        break;
                }
            }
        }
        return roleList;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("Team: ").append(id)
                .append("\nname: ").append(name)
                .append("\nPersonal: ").append(isPersonal)
                .append("\nRoles: ").append(String.join(", ", rolesAsString()))
                .append("\nCreated At: ").append(createdAt)
                .append("\nUpdated At: ").append(updatedAt);
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public boolean isPersonal() {
        return isPersonal;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
