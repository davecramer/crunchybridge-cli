package com.crunchydata.command;

import com.crunchydata.Context;
import com.crunchydata.bctl.service.CrunchyBridgeApi;
import com.crunchydata.model.AccessToken;
import com.crunchydata.model.TeamInfo;
import com.crunchydata.model.Teams;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import picocli.CommandLine;

import javax.inject.Inject;
import java.net.URI;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "ls", mixinStandardHelpOptions = true)
public class TeamList implements Callable<Integer> {
    @Inject
    Context context;

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

            Teams teams = crunchyBridgeApi.getTeams(context.getAccessToken().getToken());
            for (TeamInfo team: teams.getTeamList()) {
                System.out.println(team);
            }
        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }
}
