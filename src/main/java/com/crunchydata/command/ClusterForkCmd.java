package com.crunchydata.command;

import com.crunchydata.completions.ClusterIdCompletion;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "fork", mixinStandardHelpOptions = true)
public class ClusterForkCmd extends BaseCmd implements Callable<Integer>  {

    @CommandLine.Parameters(paramLabel = "Cluster Id", description = "Id of the cluster", completionCandidates = ClusterIdCompletion.class)
    String clusterId;

    @Override
    public Integer call() throws Exception {
        super.loadAccessToken();
        crunchyBridgeApi.forkCluster(context.getAccessToken().getToken(), clusterId);
        return 0;
    }
}
