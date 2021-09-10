package com.crunchydata.command;

import com.crunchydata.Context;
import com.crunchydata.bctl.service.CrunchyBridgeApi;
import com.crunchydata.completions.ClusterIdCompletion;
import com.crunchydata.model.AccessToken;
import com.crunchydata.model.Cluster;
import com.crunchydata.model.Clusters;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import picocli.CommandLine;

import javax.inject.Inject;
import java.net.URI;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "info", mixinStandardHelpOptions = true)
public class ClusterInfo implements Callable<Integer> {

    @Inject
    Context context;

    @CommandLine.Parameters(paramLabel = "Cluster Id", description = "Id of the cluster", completionCandidates = ClusterIdCompletion.class)
    String clusterId;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
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

            Cluster cluster = crunchyBridgeApi.getClusterInfo(context.getAccessToken().getToken(), clusterId);
            System.out.println(cluster);
        } catch (Exception ex ){
            ex.printStackTrace();
        }

        System.out.println("Cluster Info " + clusterId);
        return 0;
    }
}
