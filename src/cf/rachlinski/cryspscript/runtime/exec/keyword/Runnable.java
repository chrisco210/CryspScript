package cf.rachlinski.cryspscript.runtime.exec.keyword;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Add this annotation to a class describing a keyword that implements the{@code Keyword} class
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Runnable
{
	/**
	 * The call name of the keyword
	 */
	String value() default "";
}
