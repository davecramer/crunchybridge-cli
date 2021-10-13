package com.crunchydata.command;

import com.crunchydata.model.FireWallRules;
import com.crunchydata.model.FireWall;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "ls", mixinStandardHelpOptions = true)
public class ClusterFirewallListCmd extends BaseCmd implements Callable<Integer> {
    @CommandLine.Option(names={"--cluster_id"}, description = "Cluster Id")
    String clusterId;

    @Override
    public Integer call() throws Exception {
        try {
            loadAccessToken();

            FireWallRules rules = crunchyBridgeApi.getRules(context.getAccessToken().getToken(), clusterId);

            for (FireWall rule:rules.getRules()) {
                System.out.println(rule);
            }
        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }
}
