package com.crunchydata.command;

import com.crunchydata.model.Cluster;
import com.crunchydata.model.Clusters;
import picocli.CommandLine;

@CommandLine.Command(name = "ls", mixinStandardHelpOptions = true)
public class ClusterListCmd extends  BaseCmd implements Runnable {

    @CommandLine.Option(names={"--team_id"}, description = "List clusters owned by team")
    String teamId;

    @Override
    public void run() {
        try {
            loadAccessToken();

            Clusters clusters = crunchyBridgeApi.getClusters(context.getAccessToken().getToken(), teamId);

            for (Cluster cluster:clusters.getClusterList()) {
                System.out.println(cluster);
            }
        } catch (Exception ex ){
            ex.printStackTrace();
        }
    }
}
