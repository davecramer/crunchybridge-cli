package com.crunchydata.command;

import picocli.CommandLine;

@CommandLine.Command(name="firewall", subcommands = {
         ClusterFirewallCreateCmd.class, ClusterFirewallUpdateCmd.class, ClusterFirewallDeleteCmd.class, ClusterFirewallListCmd.class},description = "Firewall Commands" )
public class ClusterFirewallCmd {
}
