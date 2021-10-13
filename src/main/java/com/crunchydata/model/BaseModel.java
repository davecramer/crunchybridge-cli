package com.crunchydata.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

@RegisterForReflection
public class BaseModel {

    public String id;
    public String toJson() {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(this);
    }

    public String getId() {
        return id;
    }
}
