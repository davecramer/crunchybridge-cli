package com.crunchydata.command;

import picocli.CommandLine;

@CommandLine.Command(name="logger", subcommands = {
         ClusterLoggerListCmd.class},description = "Logger Commands" )
public class ClusterLoggerCmd {
}
