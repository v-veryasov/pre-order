package ru.edu.iorder.sso.auth.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@ConditionalOnMissingBean(value = ResourceServerConfigurerAdapter.class)
public class ResourceServerAutoConfiguration extends ResourceServerConfigurerAdapter {

    //TODO: проверить!!!
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("auth-sso").stateless(false);
    }
}
