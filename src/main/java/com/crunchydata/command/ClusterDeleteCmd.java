package com.crunchydata.command;

import com.crunchydata.completions.ClusterIdCompletion;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "delete", mixinStandardHelpOptions = true)
public class ClusterDeleteCmd extends BaseCmd implements Callable<Integer>  {

    @CommandLine.Parameters(paramLabel = "Cluster Id", description = "Id of the cluster", completionCandidates = ClusterIdCompletion.class)
    String clusterId;

    @Override
    public Integer call() throws Exception {
        super.loadAccessToken();
        crunchyBridgeApi.deleteCluster(context.getAccessToken().getToken(), clusterId);
        return 0;
    }
}
