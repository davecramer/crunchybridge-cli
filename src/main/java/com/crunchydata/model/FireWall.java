package com.crunchydata.model;

public class FireWall extends BaseModel{
    String rule;

    public FireWall(String id, String rule){
        this.id = id;
        this.rule = rule;
    }
    public FireWall(String rule) {
        this.rule = rule;
    }
    public String getRule() {
        return rule;
    }

    @Override
    public String toString() {
        return "FireWall: " +
                "id: " + id +
                "rule: " + rule;
    }
}
