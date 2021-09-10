package com.crunchydata.command;

import picocli.CommandLine;

@CommandLine.Command(name = "cluster-id-completions", hidden = true)
public class ClusterIdCompletionCandidate implements Runnable{

    @Override
    public void run() {
        System.out.println("1 2 3 4");
    }
}
