package com.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.logging.Logger;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class LivreMarketplaceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LivreMarketplaceApplication.class);
        application.run(args);
    }

}