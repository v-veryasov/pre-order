package ru.edu.iorder.sso.auth.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@ConditionalOnMissingBean(value = ResourceServerConfigurerAdapter.class)
//@ConditionalOnProperty(name = "security.enabled", havingValue = "true", matchIfMissing = true)
public class ResourceServerAutoConfiguration {
}
