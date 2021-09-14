package com.crunchydata.command;

import com.crunchydata.completions.ClusterIdCompletion;
import com.crunchydata.model.Cluster;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "info", mixinStandardHelpOptions = true)
public class ClusterInfo extends BaseCmd implements Callable<Integer> {

    @CommandLine.Parameters(paramLabel = "Cluster Id", description = "Id of the cluster", completionCandidates = ClusterIdCompletion.class)
    String clusterId;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        super.loadAccessToken();
        Cluster cluster = crunchyBridgeApi.getClusterInfo(context.getAccessToken().getToken(), clusterId);
        if (outputJson) {
            System.out.println(cluster.toJson());
        } else {
            System.out.println(cluster);
        }
        return 0;
    }
}
