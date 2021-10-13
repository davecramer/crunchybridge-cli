package com.crunchydata.command;

import com.crunchydata.model.Plan;
import com.crunchydata.model.Provider;
import com.crunchydata.model.Providers;
import com.crunchydata.model.Region;
import picocli.CommandLine;

@CommandLine.Command(name = "provider-completions", hidden = true)
public class ProviderCompletionCandidate extends BaseCmd implements Runnable {
    public void run() {
        try {
            loadAccessToken();

            Providers providers = crunchyBridgeApi.getProviders(context.getAccessToken().getToken());

            for (Provider provider : providers.getProviders()) {
                System.out.println(provider.getDisplayName() );
                for( Region region : provider.getRegions() ) {
                    System.out.println(region.getDisplayName() + " id: " + region.getId() + " location: " + region.getLocation());
                }
                for( Plan plan : provider.getPlans() ) {
                    System.out.println(plan.getDisplayName()+ " id: " + plan.id + " cpu: " + plan.getCpu() + " memory: " +plan.getMemory());
                }

            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
