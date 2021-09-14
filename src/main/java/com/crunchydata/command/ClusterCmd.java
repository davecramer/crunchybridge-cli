package com.crunchydata.command;

import picocli.CommandLine;

@CommandLine.Command(name="cluster", subcommands = {ClusterList.class, ClusterInfo.class, ClusterCreate.class},description = "Displays detailed information about the specified resource" )
public class ClusterCmd  {
}
