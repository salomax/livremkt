package com.marketplace.utils;

import com.google.appengine.api.utils.SystemProperty;

/**
 * @author salomao.marcos@gmail.com
 * @since 22/05/17
 */
public class LivreMarketplaceUtils {

    public static boolean isProduction() {
        return SystemProperty.environment.value() == SystemProperty.Environment.Value.Production;
    }

    public static SystemProperty.Environment.Value getEnvironment() {
        return SystemProperty.environment.value();
    }

}
