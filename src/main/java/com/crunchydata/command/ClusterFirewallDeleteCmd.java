package com.crunchydata.command;

import com.crunchydata.model.FireWall;
import picocli.CommandLine;

@CommandLine.Command(name = "delete", mixinStandardHelpOptions = true)
public class ClusterFirewallDeleteCmd extends BaseCmd{
    @CommandLine.Option(names={"--cluster_id"}, description = "Cluster Id")
    String clusterId;
    @CommandLine.Option(names={"--rule_id"}, description = "Firewall Rule Id")
    String ruleId;


    public Integer call() throws Exception {
        try {
            loadAccessToken();
            crunchyBridgeApi.deleteRule(context.getAccessToken().getToken(), clusterId, ruleId);

        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }

}
