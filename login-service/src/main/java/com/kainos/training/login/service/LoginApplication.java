package com.kainos.training.login.service;

import com.kainos.training.login.service.resource.BookResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.kainos.training.login.service.resource.LoginResource;
import com.kainos.training.login.service.configuration.LoginConfiguration;

public class LoginApplication extends Application<LoginConfiguration> {

    public static void main(String[] args) throws Exception {
        new LoginApplication().run(args);
    }

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public void run(LoginConfiguration configuration,
                    Environment environment) {
        final LoginResource resource = new LoginResource(
                configuration.getUserName(),
                configuration.getPassword()
        );
        final BookResource bookResource = new BookResource();
        environment.jersey().register(resource);
        environment.jersey().register(bookResource);
    }

}
