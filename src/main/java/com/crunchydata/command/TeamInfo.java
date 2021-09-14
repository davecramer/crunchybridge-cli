package com.crunchydata.command;

import com.crunchydata.completions.TeamIdCompletion;
import com.crunchydata.model.AccessToken;
import com.crunchydata.model.Team;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "info", mixinStandardHelpOptions = true)
public class TeamInfo extends  BaseCmd implements Callable<Integer> {

    @CommandLine.Parameters(paramLabel = "Team Id", description = "Id of the team", completionCandidates = TeamIdCompletion.class)
    String teamId;

    @Override
    public Integer call() throws Exception {
        AccessToken accessToken = null;
        try {
            loadAccessToken();

            Team team = crunchyBridgeApi.getTeamInfo(context.getAccessToken().getToken(), teamId);
            if (outputJson) {
                System.out.println(team.toJson());
            } else {
                System.out.println(team);
            }
        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }
}
