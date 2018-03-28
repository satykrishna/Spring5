package spring.aspect.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCutDefinitionsForCalculator {

	@Pointcut("execution(* *.*(..))")
	public void loggingOperation() {
	}

}
