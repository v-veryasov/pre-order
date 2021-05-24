package ru.edu.iorder.profile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import static org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest.toAnyEndpoint;

@Configuration
@EnableOAuth2Sso
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.oauth2.client.clientId}")
    private String clientId;

    @Value("${security.oauth2.client.clientSecret}")
    private String clientSecret;

    @Value("${security.oauth2.resource.tokenInfoUri}")
    private String checkAuthUrl;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }

    //@Bean
    //public ResourceServerTokenServices tokenServices() {
    //    RemoteTokenServices tokenServices = new RemoteTokenServices();
    //    tokenServices.setClientId(clientId);
    //    tokenServices.setClientSecret(clientSecret);
    //    tokenServices.setCheckTokenEndpointUrl(checkAuthUrl);
    //    return tokenServices;
    //}
    //
    //@Override
    //public AuthenticationManager authenticationManagerBean() throws Exception {
    //    OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
    //    authenticationManager.setTokenServices(tokenServices());
    //    return authenticationManager;
    //}
}