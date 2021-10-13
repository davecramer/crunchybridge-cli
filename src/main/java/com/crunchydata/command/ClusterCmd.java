package com.crunchydata.command;

import picocli.CommandLine;

@CommandLine.Command(name="cluster", subcommands = {
        ClusterListCmd.class, ClusterInfo.class, ClusterCreateCmd.class, ClusterForkCmd.class, ClusterDeleteCmd.class, ClusterFirewallCmd.class, ClusterLoggerCmd.class
},description = "Cluster Commands" )
public class ClusterCmd  {
}
