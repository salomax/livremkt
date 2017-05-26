package com.marketplace;

import com.marketplace.security.GoogleTokenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import java.util.logging.Logger;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity(debug = false)
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private OAuth2ClientProperties oAuthProperties;

    @Bean
    public RemoteTokenServices remoteTokenServices() {
        RemoteTokenServices tokenServices = new GoogleTokenServices();
        tokenServices.setClientId(this.oAuthProperties.getClientId());
        tokenServices.setClientSecret(this.oAuthProperties.getClientSecret());
        tokenServices.setCheckTokenEndpointUrl("https://www.googleapis.com/oauth2/v1/tokeninfo");
        return tokenServices;
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/**")
            .csrf()
            .disable()
            .authorizeRequests().anyRequest().authenticated().and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.tokenServices(remoteTokenServices());
    }

}