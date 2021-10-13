package com.crunchydata.command;

import com.crunchydata.model.Logger;
import com.crunchydata.model.Loggers;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "ls", mixinStandardHelpOptions = true)
public class ClusterLoggerListCmd extends BaseCmd implements Callable<Integer> {
    @CommandLine.Option(names={"--cluster_id"}, description = "Cluster Id")
    String clusterId;

    @Override
    public Integer call() throws Exception {
        try {
            loadAccessToken();

            Loggers loggers = crunchyBridgeApi.getLoggers(context.getAccessToken().getToken(), clusterId);

            for (Logger logger:loggers.getLoggers()) {
                System.out.println(logger);
            }
        } catch (Exception ex ){
            ex.printStackTrace();
        }
        return 0;
    }
}
