package org.hypnos.spring6.validator.annotation;

import org.hypnos.spring6.validator.FileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/5/3-15:33
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {FileValidator.class})
public @interface FileConstraint {
    long maxSize () default 1048576L;
    String[] allowedTypes () default {};
    Class<?> [] groups () default {};
    Class<? extends Payload> [] payload () default {};
}
