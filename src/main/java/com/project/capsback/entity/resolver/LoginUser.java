package com.project.capsback.entity.resolver;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target(PARAMETER)
@Retention(RUNTIME)
@Documented
public @interface LoginUser {
}
