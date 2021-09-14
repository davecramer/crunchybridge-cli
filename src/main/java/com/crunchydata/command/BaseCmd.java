package com.crunchydata.command;

import com.crunchydata.Context;
import com.crunchydata.bctl.service.CrunchyBridgeApi;
import com.crunchydata.model.AccessToken;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import picocli.CommandLine;

import javax.inject.Inject;
import java.net.URI;

public class BaseCmd {
    @Inject
    Context context;

    @CommandLine.Option(names = {"--json"})
    boolean outputJson;

    protected CrunchyBridgeApi crunchyBridgeApi;
    protected void loadAccessToken() throws Exception {
     crunchyBridgeApi =
            (CrunchyBridgeApi) RestClientBuilder.newBuilder()
                    .baseUri(new URI("https://api.crunchybridge.com/")).build(CrunchyBridgeApi.class);
    AccessToken accessToken = null;

        accessToken = context.getAccessToken();
        if (accessToken == null) {

            AccessToken accessToken1 = crunchyBridgeApi.getAccessToken(context.getCredentials());
            context.setAccessToken(accessToken1);
        }

    }
}
