package com.crunchydata.bctl.service;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

public class CrunchyBridgeResponseExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public RuntimeException toThrowable(Response response) {
        ErrorResponse error = response.readEntity(ErrorResponse.class);
        return new CrunchyBridgeException(error);
    }
}
