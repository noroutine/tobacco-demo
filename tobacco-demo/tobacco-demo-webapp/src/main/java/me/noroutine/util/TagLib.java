package me.noroutine.util;

/**
 * @author Oleksii Khilkevych
 * @since 07.12.12
 */

public class TagLib {

    public static String minifiedJS(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("URL should not be blank");
        }

        if (url.toLowerCase().endsWith(".min.js")) {
            return url;
        }

        if (url.toLowerCase().startsWith("/resources/")) {
            return url.replaceAll("\\.js$", ".min.js");
        }

        return url;
    }

}
