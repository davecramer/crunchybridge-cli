package com.crunchydata.command;

import com.crunchydata.model.ConnectionCredentials;
import picocli.CommandLine;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "credentials", mixinStandardHelpOptions = true)
public class CredentialsCmd extends  BaseCmd implements Callable<Integer> {

    @CommandLine.Parameters(paramLabel = "Cluster Id", description = "Id of the cluster")
    String clusterId;

    @Override
    public Integer call() throws Exception {
        ConnectionCredentials connectionCredentials = crunchyBridgeApi.getCredentials(context.getAccessToken().getToken(), clusterId, "default");
        if (outputJson) {
            System.out.println(connectionCredentials.toJson());
        } else {
            System.out.println(connectionCredentials);
        }
        return 0;
    }
}
