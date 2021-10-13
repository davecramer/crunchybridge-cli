package com.crunchydata;


import com.crunchydata.command.LoginCmd;
import com.crunchydata.model.AccessToken;
import com.crunchydata.model.Credentials;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import picocli.CommandLine;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Context {
    @ConfigProperty(name="application.key")
    String applicationKey;

    @ConfigProperty(name="application.secret")
    String applicationSecret;

    private AccessToken accessToken;

    public AccessToken getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public String getApplicationSecret() {
        return applicationSecret;
    }

    public void setApplicationSecret(String applicationSecret) {
        this.applicationSecret = applicationSecret;
    }

    public Credentials getCredentials() {
        if (applicationSecret == null || applicationKey == null ){
            try {
                CommandLine cmdLine = new CommandLine(new LoginCmd());
                cmdLine.execute(new String []{""});
                return cmdLine.getExecutionResult();
            } catch (Exception ex){
                //ignore
            }
        }
        return new Credentials(applicationKey, applicationSecret );
    }

}
