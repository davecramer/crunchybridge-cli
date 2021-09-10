package com.crunchydata.command;

import com.crunchydata.Context;
import com.crunchydata.bctl.service.CrunchyBridgeApi;
import com.crunchydata.completions.TeamIdCompletion;
import com.crunchydata.model.AccessToken;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import picocli.CommandLine;

import javax.inject.Inject;
import java.net.URI;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "cert", mixinStandardHelpOptions = true)
public class TeamCertCmd implements Callable<Integer> {
    @Inject
    Context context;

    @CommandLine.Parameters(paramLabel = "Team Id", description = "Id of the team", completionCandidates = TeamIdCompletion.class)
    String teamId;

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

            String cert = crunchyBridgeApi.getTeamCert(context.getAccessToken().getToken(), teamId);
            System.out.println(cert);
        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }
}
