package com.crunchydata.command;

import com.crunchydata.model.AccessToken;
import com.crunchydata.model.Team;
import com.crunchydata.model.Teams;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "ls", mixinStandardHelpOptions = true)
public class TeamList extends  BaseCmd implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        AccessToken accessToken = null;
        try {
            loadAccessToken();
            Teams teams = crunchyBridgeApi.getTeams(context.getAccessToken().getToken());
            for (Team team: teams.getTeamList()) {
                if (outputJson) {
                    System.out.println(team.toJson());
                } else {
                    System.out.println(team);
                }
            }
        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }
}
