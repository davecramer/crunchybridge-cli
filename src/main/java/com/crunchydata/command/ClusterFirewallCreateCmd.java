package com.crunchydata.command;

import com.crunchydata.model.Rule;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "create", mixinStandardHelpOptions = true)
public class ClusterFirewallCreateCmd extends BaseCmd implements Callable<Integer> {
    @CommandLine.Option(names={"--cluster_id"}, description = "Cluster Id")
    String clusterId;
    @CommandLine.Parameters(description = "Firewall Rule")
    String rule;

    @Override
    public Integer call() throws Exception {
        try {
            loadAccessToken();
            Rule fireWallRule = new Rule(rule);
            crunchyBridgeApi.createRule(context.getAccessToken().getToken(), clusterId, fireWallRule);

        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }
}
