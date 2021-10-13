package com.crunchydata.command;

import com.crunchydata.model.FireWall;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "update", mixinStandardHelpOptions = true)
public class ClusterFirewallUpdateCmd extends BaseCmd implements Callable<Integer> {
    @CommandLine.Option(names={"--cluster_id"}, description = "Cluster Id")
    String clusterId;
    @CommandLine.Option(names={"--rule_id"}, description = "Firewall Rule Id")
    String ruleId;
    @CommandLine.Parameters(description="Rule")
    String rule;

    public Integer call() throws Exception {
        try {
            FireWall fireWallrule = new FireWall(ruleId, rule);
            loadAccessToken();
            crunchyBridgeApi.updateRule(context.getAccessToken().getToken(), clusterId, ruleId, fireWallrule);

        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }

}
