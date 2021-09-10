package com.crunchydata.command;

import picocli.CommandLine;

@CommandLine.Command(name="provider", subcommands = {ProviderList.class},description = "Display providers" )

public class ProviderCmd {
}
