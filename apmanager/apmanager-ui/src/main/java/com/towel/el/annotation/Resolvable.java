package com.towel.el.annotation;

import com.towel.bean.DefaultFormatter;
import com.towel.el.handler.MethodHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Resolvable {
	public String colName() default "";

	public Class<?> formatter() default DefaultFormatter.class;

	public Class<?> accessMethod() default MethodHandler.class;
}
