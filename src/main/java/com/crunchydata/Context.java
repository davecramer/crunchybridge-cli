package com.crunchydata;


import com.crunchydata.model.AccessToken;
import com.crunchydata.model.Credentials;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Context {
    @ConfigProperty(name="application.key")
    private String applicationKey;

    @ConfigProperty(name="application.secret")
    private String applicationSecret;

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
        return new Credentials(applicationKey, applicationSecret );
    }

}
