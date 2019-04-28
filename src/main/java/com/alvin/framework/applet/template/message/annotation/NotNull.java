package com.alvin.framework.applet.template.message.annotation;

import java.lang.annotation.*;

/**
 * datetime 2019/4/28 14:54
 *
 * @author sin5
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
public @interface NotNull {
}
