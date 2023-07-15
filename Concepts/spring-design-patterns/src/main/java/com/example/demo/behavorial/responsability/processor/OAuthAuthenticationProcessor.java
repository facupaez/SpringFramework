package com.example.demo.behavorial.responsability.processor;

import com.example.demo.behavorial.responsability.AuthenticationProcessor;
import com.example.demo.behavorial.responsability.AuthenticationProvider;
import com.example.demo.behavorial.responsability.provider.OAuthProvider;

public class OAuthAuthenticationProcessor extends AuthenticationProcessor {


    public OAuthAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        // comprobaciones particulares de este proceso
        if (provider instanceof OAuthProvider){
            return true;
        }

        // llama al siguiente proceso
        return next.isAuthorized(provider);
    }
}
