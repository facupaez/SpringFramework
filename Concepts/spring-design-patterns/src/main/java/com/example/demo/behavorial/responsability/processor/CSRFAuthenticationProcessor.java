package com.example.demo.behavorial.responsability.processor;

import com.example.demo.behavorial.responsability.AuthenticationProcessor;
import com.example.demo.behavorial.responsability.AuthenticationProvider;
import com.example.demo.behavorial.responsability.provider.CSRFProvider;

public class CSRFAuthenticationProcessor extends AuthenticationProcessor {


    public CSRFAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        // comprobaciones particulares de este proceso
        if (provider instanceof CSRFProvider){
            return true;
        }

        // llama al siguiente proceso
        return next.isAuthorized(provider);
    }
}
