package annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

public class FrameworkAnnotation 
{
	@Retention(RUNTIME)
	@Target(METHOD)
	@Documented
	public @interface FrameworkAnnotations
	{
		public String author();
		public String category();
		public String bddScenario();
	}
}
