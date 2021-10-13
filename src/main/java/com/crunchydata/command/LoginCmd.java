package com.crunchydata.command;

import com.crunchydata.Context;
import com.crunchydata.model.Credentials;
import picocli.CommandLine;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "login")
public class LoginCmd implements Callable <Credentials> {

    @Inject
    Context context;

    String applicationKey;
    @CommandLine.Option(names={"-s", "--secret"}, description = "Application Secret", interactive = true)
    String applicationSecret;

    private String readLine(String prompt, String ... args) throws  Exception{
        if (System.console() != null) {
            return System.console().readLine(prompt);
        } else {
            System.out.print(String.format(prompt, args));
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    System.in));
            return reader.readLine();
        }
    }
    @Override
    public Credentials call() throws Exception {
        if (applicationKey == null) {
            applicationKey = readLine("Application Key: ");
        }
        if (applicationSecret == null ) {
            if (System.console() == null ) {
                applicationSecret = readLine("Application Secret:");
            }else {
               applicationSecret = new String(System.console().readPassword("Application Secret"));
            }
        }

        context.setApplicationKey(applicationKey);
        context.setApplicationSecret(applicationSecret);
        return new Credentials(applicationKey, applicationSecret);
    }
}
