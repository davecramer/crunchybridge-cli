package com.crunchydata.model;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class BaseModel {
    protected String id;
    public String toJson() {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(this);
    }

    public String getId() {
        return id;
    }
}
