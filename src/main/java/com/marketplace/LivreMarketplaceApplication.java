package com.marketplace;

import com.marketplace.controller.ProductController;
import com.marketplace.utils.LivreMarketplaceUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.logging.Logger;

/**
 * @author salomao.marcos@gmail.com
 * @since 21/05/17
 */
// Jmx must be turned off because AppEngine doesn't allow it
@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class LivreMarketplaceApplication extends SpringBootServletInitializer {

    private static final Logger log = Logger.getLogger(ProductController.class.getName());

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(LivreMarketplaceApplication.class);

        // Set profile (dev/server)
        setProfile(application);

        application.run(args);
    }

    private static void setProfile(SpringApplication application) {

        log.warning("Environment " + LivreMarketplaceUtils.getEnvironment());

        application.setAdditionalProfiles("dev");

        if (LivreMarketplaceUtils.isProduction()) {
            log.warning("Set profile to server");
            application.setAdditionalProfiles("server");
        } else {
            log.warning("Set profile to dev");
            application.setAdditionalProfiles("dev");
        }

    }

}