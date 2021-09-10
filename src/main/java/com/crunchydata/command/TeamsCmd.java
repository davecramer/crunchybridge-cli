package com.crunchydata.command;

import picocli.CommandLine;

@CommandLine.Command(name="team", subcommands = {TeamList.class, TeamCertCmd.class, TeamInfo.class},description = "Displays Teams information" )
public class TeamsCmd {
}
