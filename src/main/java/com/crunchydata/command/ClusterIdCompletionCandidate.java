package com.crunchydata.command;

import com.crunchydata.model.Cluster;
import com.crunchydata.model.Clusters;
import picocli.CommandLine;

@CommandLine.Command(name = "cluster-id-completions", hidden = true)
public class ClusterIdCompletionCandidate extends BaseCmd implements Runnable {

    @Override
    public void run() {
        try {
            loadAccessToken();

            Clusters clusters = crunchyBridgeApi.getClusters(context.getAccessToken().getToken(), null);

            for (Cluster cluster : clusters.getClusterList()) {
                System.out.print(cluster.id + ' ');
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
