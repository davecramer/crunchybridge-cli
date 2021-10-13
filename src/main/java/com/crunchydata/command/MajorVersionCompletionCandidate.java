package com.crunchydata.command;

import picocli.CommandLine;

@CommandLine.Command(name = "major-version-completions", hidden = true)
public class MajorVersionCompletionCandidate extends BaseCmd implements Runnable {

    @Override
    public void run() {
        System.out.println("11 12 13");
    }
}
