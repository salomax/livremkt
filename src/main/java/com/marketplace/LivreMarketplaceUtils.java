package com.marketplace;

import com.google.appengine.api.utils.SystemProperty;

/**
 * @author salomao.marcos@gmail.com
 * @since 23/05/17
 */
public class LivreMarketplaceUtils {

    public static SystemProperty.Environment.Value getEnvironment() {
        return SystemProperty.environment.value();
    }

    public static boolean isProduction() {
        return SystemProperty.environment.value() == SystemProperty.Environment.Value.Production;
    }

}
