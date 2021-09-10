package com.crunchydata.command;

import com.crunchydata.model.AccessToken;
import com.crunchydata.model.Cluster;
import com.crunchydata.model.Clusters;
import com.crunchydata.Context;
import com.crunchydata.bctl.service.CrunchyBridgeApi;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import picocli.CommandLine;

import javax.inject.Inject;
import java.net.URI;


@CommandLine.Command(name = "ls", mixinStandardHelpOptions = true)
public class ClusterList implements Runnable {
    @Inject
    Context context;

    @CommandLine.Option(names={"--team_id"}, description = "List clusters owned by team")
    String team_id;

    @Override
    public void run() {
        AccessToken accessToken = null;
        try {
            CrunchyBridgeApi crunchyBridgeApi =
                    (CrunchyBridgeApi) RestClientBuilder.newBuilder()
                            .baseUri(new URI("https://api.crunchybridge.com/")).build(CrunchyBridgeApi.class);

            accessToken = context.getAccessToken();
            if (accessToken == null ){

                AccessToken accessToken1 = crunchyBridgeApi.getAccessToken(context.getCredentials());
                context.setAccessToken(accessToken1);
            }

            Clusters clusters = crunchyBridgeApi.getClusters(context.getAccessToken().getToken(), team_id);

            for (Cluster cluster:clusters.getClusterList()) {
                System.out.println(cluster);
            }
        } catch (Exception ex ){
            ex.printStackTrace();
        }
    }
}
