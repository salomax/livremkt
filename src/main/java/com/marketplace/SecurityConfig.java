package com.marketplace;

import com.marketplace.security.GoogleTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
@Configuration
@EnableResourceServer
@EnableWebSecurity(debug = false)
public class SecurityConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public RemoteTokenServices remoteTokenServices() {
        RemoteTokenServices tokenServices = new GoogleTokenServices();
        // TODO Externalize it
        tokenServices.setClientId("153735516776-pn3ugri15npc97a7ttrtm2opl34sf5f9.apps.googleusercontent.com");
        tokenServices.setClientSecret("5mHIWwhHS5tRENJOMx2XCxgi");
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