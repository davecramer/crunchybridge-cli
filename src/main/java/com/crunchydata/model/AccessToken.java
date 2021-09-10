package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken {

    private String tokenType;
    @JsonProperty("access_token")
    private String token;
    @JsonProperty("expires_in")
    private long expiry;

    public AccessToken() {
        this.tokenType = "bearer";
    }
    public AccessToken(String tokenType, String token, long expiry) {
        this.tokenType = tokenType;
        this.token = token;
        this.expiry = expiry;
    }
    public String getToken() {
        return "Bearer " + token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiry() {
        return expiry;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }
}
