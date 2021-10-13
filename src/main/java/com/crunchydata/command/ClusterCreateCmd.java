package com.crunchydata.command;

import com.crunchydata.completions.ProviderCompletion;
import com.crunchydata.model.Cluster;
import picocli.CommandLine;
import java.util.concurrent.Callable;
/*
{
    "name": "staging",
    "team_id": "eaevtjiudzeq7bsqbbpiscund4",
    "plan_id": "hobby-2",
    "storage": 100,
    "provider_id": "aws",
    "region_id": "us-east-1",
    "major_version": 13
  }
  "team_id":"yu75urhhxbhztiimoqpmrvmyzi",
"provider_id":"aws",
"region_id":"us-east-1",
"created_at":null,
"updated_id":null,
"major_version":13,
"storage":100,
"is_ha":false,
"plan_id":"Hobby-1"

 */
@CommandLine.Command(name = "create", mixinStandardHelpOptions = true)
public class ClusterCreateCmd extends BaseCmd implements Callable<Integer> {

    @CommandLine.Parameters(paramLabel = "HELP", description = "Show providers", completionCandidates = ProviderCompletion.class)
    String help;
    /*
    <--platform|-p> <--region|-r> <--plan> <--team|-t> <--version|-v>[--size|-s] [--name|-n] [--ha]
    --fork ID [--at] [--platform|-p] [--region|-r] [--plan] [--size|-s] [--name|-n] [--ha]
    --replica ID [--platform|-p] [--region|-r] [--plan] [--name|-n]
     */

    @CommandLine.Option(names={"-p",  "--platform, "}, description = "Cloud provider")
    String platform;
    @CommandLine.Option(names={"-r",  "--region, "}, description = "Region/Location")
    String region;
    @CommandLine.Option(names={"--plan"}, description = "Plan Server CPU/memory" )
    String plan;
    @CommandLine.Option(names={"-t", "--team"}, description = "team id")
    String teamId;
    @CommandLine.Option(names={"-m", "--majorVersion"}, description = "Postgresql Version")
    Integer version;

    @CommandLine.Option(names={"-s",  "--size"}, description = "Storage size in GB")
    Integer size;
    @CommandLine.Option(names={"-n", "--name"}, description = "Name of cluster")
    String name;
    @CommandLine.Option(names={"--ha"}, description = "Provision as Highly Available")
    boolean highAvailability;
    @CommandLine.Option(names={"--fork"}, description = "Choose cluster to fork")
    String forkId;
    @CommandLine.Option(names={"--replica"}, description = "Choose cluster for read replica")
    String replicaId;
    @CommandLine.Option(names={"--at"}, description = "Recovery point-in-time in RFC3339 (default: now)")
    String atTime;
    @CommandLine.Option(names={"--network"}, description = "Network Id from team networks command")
    String networkId;

    @Override
    public Integer call() throws Exception {
        loadAccessToken();

/*
            CrunchyBridgeApi crunchyBridgeApi1 =
                    (CrunchyBridgeApi) RestClientBuilder.newBuilder()
                            .baseUri(new URI("http://api.crunchybridge.com/")).build(CrunchyBridgeApi.class);
*/
        Cluster cluster = new Cluster();
        cluster.setName(name);
        cluster.setProviderId(platform);
        cluster.setRegionId(region);
        cluster.setStorage(size);
        cluster.setPlan(plan);
        cluster.setMajorVersion(version);
        cluster.setTeamId(teamId);
        cluster.networkId = networkId;
        if (highAvailability) {
            cluster.setHa(highAvailability);
        }


        crunchyBridgeApi.createCluster(context.getAccessToken().getToken(), cluster);
        System.out.println("Cluster created");


        return 0;
    }
}
