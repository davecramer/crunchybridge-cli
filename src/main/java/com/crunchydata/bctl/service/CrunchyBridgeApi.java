package com.crunchydata.bctl.service;


import com.crunchydata.AccessToken;
import com.crunchydata.command.Cluster;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import java.util.Map;

@Path("/")
@RegisterRestClient
@RegisterProvider(value = CrunchyBridgeResponseExceptionMapper.class, priority = 50)
@Produces("application/json")
public interface CrunchyBridgeApi {
    @GET
    @Path("/clusters")
    Map<String, Cluster> getClusters(@HeaderParam("Authorization") String authorization);

    @POST
    @Path("access-tokens")
    AccessToken getAccessToken(String clientId, String clientSecret);
}
