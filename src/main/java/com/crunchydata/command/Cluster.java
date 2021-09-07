package com.crunchydata.command;

import com.crunchydata.AccessToken;
import com.crunchydata.Context;
import com.crunchydata.bctl.service.Authenticate;
import com.crunchydata.bctl.service.CrunchyBridgeApi;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import picocli.CommandLine;

import javax.inject.Inject;
import java.net.URI;

@CommandLine.Command(name = "clusters", mixinStandardHelpOptions = true)
public class Cluster implements Runnable {
    @Inject
    Context context;

    @Override
    public void run() {
        AccessToken accessToken = null;
        try {
            CrunchyBridgeApi crunchyBridgeApi =
                    (CrunchyBridgeApi) RestClientBuilder.newBuilder()
                            .baseUri(new URI("https://api.crunchybridge.com/")).build(CrunchyBridgeApi.class);

            accessToken = context.getAccessToken();
            if (accessToken == null ){
                context.setAccessToken(crunchyBridgeApi.getAccessToken(context.getApplicationKey(), context.getApplicationSecret()));
            }

            crunchyBridgeApi.getClusters(context.getAccessToken().getToken());
        } catch (Exception ex ){
            ex.printStackTrace();
        }
    }
}
