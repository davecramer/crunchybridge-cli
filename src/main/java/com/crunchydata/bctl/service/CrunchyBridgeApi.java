package com.crunchydata.bctl.service;


import com.crunchydata.model.FireWallRules;
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
    Cluster getCluster(@HeaderParam("Authorization") String authorization, @PathParam("cluster_id") String clusterId);

    @GET
    @Path("/clusters/{cluster_id}/roles/{role_id}")
    ConnectionCredentials getCredentials(@HeaderParam("Authorization") String authorization, @PathParam("cluster_id") String clusterId, @PathParam("role_id") String roleId);

    @POST
    @Path("/clusters")
    void createCluster(@HeaderParam("Authorization") String authorization, Cluster cluster);

    @POST
    @Path("/clusters/{clusterId}/forks")
    void forkCluster(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId);

    @DELETE
    @Path("/clusters/{clusterId}")
    void deleteCluster(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId);

    @GET
    @Path("/clusters/{clusterId}/firewall/{fireWallId}")
    FireWall getRule(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId, @PathParam("fireWallId")String fireWallId);

    @GET
    @Path("/clusters/{clusterId}/firewall")
    FireWallRules getRules(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId);

    @POST
    @Path("/clusters/{clusterId}/firewall")
    void createRule(@HeaderParam("Authorization") String authorization,  @PathParam("clusterId")String clusterId, Rule rule);

    @PUT
    @Path("/clusters/{clusterId}/firewall/{fireWallId}")
    void updateRule(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId, @PathParam("fireWallId")String fireWallId,   FireWall rule);

    @DELETE
    @Path("/clusters/{clusterId}/firewall/{fireWallId}")
    void deleteRule(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId, @PathParam("fireWallId")String fireWallId);

    @GET
    @Path("/clusters/{clusterId}/loggers")
    Loggers getLoggers(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId);

    @GET
    @Path("/clusters/{clusterId}/loggers/{loggerId}")
    Logger getLogger(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId, @PathParam("loggerId") String loggerId);

    @DELETE
    @Path("/clusters/{clusterId}/loggers/{loggerId}")
    void deleteLogger(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId, @PathParam("loggerId") String loggerId);

    @POST
    @Path("/clusters/{clusterId}/loggers")
    void createLogger(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId, Logger logger);

    @POST
    @Path("/clusters/{clusterId}/resize")
    void resizeCluster(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId,Resize resize);

    @GET
    @Path("/clusters/{clusterId}/resize")
    ResizeStatus getResizeStatus(@HeaderParam("Authorization") String authorization, @PathParam("clusterId")String clusterId);

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
    @Path("/teams/{id}/networks")
    NetworkList getTeamNetworkList(@HeaderParam("Authorization") String authorization, @PathParam("id") String teamId);

    @GET
    @Path("/providers")
    Providers getProviders(@HeaderParam("Authorization") String authorization);

    @POST
    @Path("access-tokens")
    AccessToken getAccessToken( Credentials credentials);
}
