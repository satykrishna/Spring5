package spring.aspect.example;

import static org.Spring.java8.util.AppLogger.log;
import static org.apache.log4j.Level.INFO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.Spring.model.Complex;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//@Component
//@Aspect

public class ComplexCachingAspect {

	private static final Logger logger = 
			Logger.getLogger(ComplexCachingAspect.class);
	
	
	private static final Map<String, Complex> cache = 
			new ConcurrentHashMap<String, Complex>();
	
    @Pointcut("call(public *.Complex.new(int, int))")
    public void cacheComplexNumber() {
    	
    }

    @Around("cacheComplexNumber()")
    public Object cacheAround(ProceedingJoinPoint jointPoint) throws Throwable {
    	
    	Object[] args = jointPoint.getArgs();
    	String key = (int)args[0] + ", " + (int)args[1];
    	
    	Complex complex = cache.get(key);
    	if(complex == null) {
    		log(logger, INFO, ()-> "Miss for (" + key + ")" );
    		complex = (Complex) jointPoint.proceed();
    		cache.put(key, complex);
    	}
    	else {
    		Complex result = complex;
    		log(logger, INFO, ()-> "Found for (" +key +") : " + result.toString());
    	}
    	return complex;
    	
    }
	
}
