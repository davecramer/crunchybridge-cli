package com.crunchydata.bctl.service;


import com.crunchydata.model.*;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;

@Path("/")
@RegisterRestClient
@RegisterProvider(value = CrunchyBridgeResponseExceptionMapper.class, priority = 50)
public interface CrunchyBridgeApi {
    @GET
    @Path("/clusters")
    Clusters getClusters(@HeaderParam("Authorization") String authorization, @QueryParam("team_id") String teamId);

    @GET
    @Path("/clusters/{cluster_id}")
    Cluster getClusterInfo(@HeaderParam("Authorization") String authorization, @PathParam("cluster_id") String clusterId);

    @GET
    @Path("/cluster")
    Cluster getCluster(@HeaderParam("Authorization") String authorization);

    @GET
    @Path("/teams")
    Teams getTeams(@HeaderParam("Authorization") String authorization);

    @GET
    @Path("/teams/{id}.pem")
    String getTeamCert(@HeaderParam("Authorization") String authorization, @PathParam("id") String teamId);

    @GET
    @Path("/teams/{id}")
    Team getTeamInfo(@HeaderParam("Authorization") String authorization, @PathParam("id") String teamId);

    @GET
    @Path("/providers")
    Providers getProviders(@HeaderParam("Authorization") String authorization);

    @POST
    @Path("access-tokens")
    AccessToken getAccessToken( Credentials credentials);
}
