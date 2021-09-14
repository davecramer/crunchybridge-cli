package com.crunchydata.command;

import com.crunchydata.model.*;
import picocli.CommandLine;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "ls", mixinStandardHelpOptions = true)
public class ProviderList extends BaseCmd implements  Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        super.loadAccessToken();
        Providers providers = crunchyBridgeApi.getProviders(context.getAccessToken().getToken());
        for (Provider provider : providers.getProviders()) {
            if (outputJson) {
                System.out.println(provider.toJson());
            } else {
                System.out.println(provider);
            }
        }
        return 0;
    }
}
