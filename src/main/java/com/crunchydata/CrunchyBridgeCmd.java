package com.crunchydata;

import com.crunchydata.command.*;
import io.quarkus.picocli.runtime.annotations.TopCommand;
import org.eclipse.microprofile.config.ConfigProvider;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(name = "bctl", mixinStandardHelpOptions = true, versionProvider = VersionProviderWithConfigProvider.class, subcommands = {
        ClusterCmd.class,
        TeamsCmd.class,
        ProviderCmd.class,
        ClusterIdCompletionCandidate.class
}, description = "A command-line interface for Crunchy Bridge"

)


public class CrunchyBridgeCmd {


}
class VersionProviderWithConfigProvider implements CommandLine.IVersionProvider {
    public String[] getVersion() {
        String applicationName = ConfigProvider.getConfig().getValue("quarkus.application.name", String.class);
        String applicationVersion = ConfigProvider.getConfig().getValue("quarkus.application.version", String.class);
        return new String[]{ String.format("%s %s", applicationName, applicationVersion) };
    }
}