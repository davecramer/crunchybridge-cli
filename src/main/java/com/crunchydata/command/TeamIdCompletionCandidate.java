package com.crunchydata.command;

import com.crunchydata.model.Team;
import com.crunchydata.model.Teams;
import picocli.CommandLine;

@CommandLine.Command(name = "team-id-completions", hidden = true)
public class TeamIdCompletionCandidate extends BaseCmd implements Runnable {
    public void run() {
        try {
            loadAccessToken();

            Teams teams = crunchyBridgeApi.getTeams(context.getAccessToken().getToken());

            for (Team team : teams.getTeamList()) {
                System.out.print(team.id + ' ');
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
