package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 {
      "cidr4": "",
      "id": "",
      "provider_id": "",
      "region_id": ""
    }
 */
public class Network extends BaseModel{
    public String cidr;

    @JsonProperty("provider_id")
    public String providerId;
    @JsonProperty("region_id")
    public String regionId;


    @Override
    public String toString() {
        return "Network: " +
                "\nid: " + id +
                "\ncidr: " + cidr +
                "\nProvider Id: " + providerId +
                "\nRegion Id: " + regionId;

    }
}
