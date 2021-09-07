package com.crunchydata.bctl.service;

import com.crunchydata.AccessToken;
import com.crunchydata.Context;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.concurrent.Callable;

public class Authenticate implements Callable <AccessToken> {

    @Inject
    Context context;

    @Override
    public AccessToken call() throws Exception {
        CrunchyBridgeApi crunchyBridgeApi =
                (CrunchyBridgeApi) RestClientBuilder.newBuilder()
                        .baseUri(new URI("https://api.crunchybridge.com/")).build(CrunchyBridgeApi.class);
        return crunchyBridgeApi.getAccessToken(context.getApplicationKey(), context.getApplicationSecret());


    }

}
