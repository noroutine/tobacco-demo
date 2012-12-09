package me.noroutine.cache;

import java.lang.annotation.*;

/**
 * @author Oleksii Khilkevych
 * @since 01.11.12
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IfNoneMatch {
    /**
     * tobacco-demo: SpEL expression to calculate ETag value
     * @return ETag for request
     */
    String value() default "";
}
