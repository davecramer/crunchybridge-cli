package com.crunchydata.bctl.service;


import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ErrorResponse {

    public int error_code;
    public String message;
}
