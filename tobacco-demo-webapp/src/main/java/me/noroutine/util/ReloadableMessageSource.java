package me.noroutine.util;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.*;

/**
 * @author Oleksii Khilkevych
 * @since 02.12.12
 */

public class ReloadableMessageSource extends ReloadableResourceBundleMessageSource {

    public Properties getProperties(Locale locale) {
        return super.getMergedProperties(locale).getProperties();
    }
}
