package com.crunchydata.model;

/*
{
  "name": "postgres",
  "password": "Yodtp6pRYzUsqNeHFIDVS3ViS266l5WeifCkdsvdzosQ1jTBMvKJKYF7h0tuMHd7",
  "uri": "postgres://postgres:Yodtp6pRYzUsqNeHFIDVS3ViS266l5WeifCkdsvdzosQ1jTBMvKJKYF7h0tuMHd7@p.33ddusyv3fgkrf2bz67bxlkpwa.db.postgresbridge.com:5432/postgres"
}

 */

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class ConnectionCredentials {
    String name;
    String password;
    String uri;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Credentials").append("\nname: ").append(name)
                .append("\npassword: ").append(password)
                .append("\nURI: ").append(uri);
        return sb.toString();
    }
    public String toJson() {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(this);
    }
}
