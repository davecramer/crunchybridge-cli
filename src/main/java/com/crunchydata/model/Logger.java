package com.crunchydata.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Logger extends BaseModel {
    private final String host;
    private final int port;
    private String template;
    private String description;

    public Logger(String host, int port, String template, String description) {
        this.host = host;
        this.port = port;
        this.template = template;
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Logger: ").append("id: ").append(id)
                .append("\nDescription: ").append(description)
                .append("\nPort: ").append(port)
                .append("\nTemplate: ").append(template);
        return sb.toString();
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getTemplate() {
        return template;
    }

    public String getDescription() {
        return description;
    }
}
