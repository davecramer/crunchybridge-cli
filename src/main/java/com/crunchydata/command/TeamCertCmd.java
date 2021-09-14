package com.crunchydata.command;

import com.crunchydata.completions.TeamIdCompletion;
import picocli.CommandLine;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "cert", mixinStandardHelpOptions = true)
public class TeamCertCmd extends  BaseCmd implements Callable<Integer> {

    @CommandLine.Parameters(paramLabel = "Team Id", description = "Id of the team", completionCandidates = TeamIdCompletion.class)
    String teamId;

    @Override
    public Integer call() throws Exception {
        try {
            loadAccessToken();
            String cert = crunchyBridgeApi.getTeamCert(context.getAccessToken().getToken(), teamId);
            System.out.println(cert);
        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }
}
