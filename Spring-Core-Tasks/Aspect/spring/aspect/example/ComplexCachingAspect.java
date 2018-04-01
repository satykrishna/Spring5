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


@Component
@Aspect

public class ComplexCachingAspect {

	private static final Logger logger = 
			Logger.getLogger(ComplexCachingAspect.class);
	
	
	private static final Map<String, Complex> cache = 
			new ConcurrentHashMap<String, Complex>();
	

    @Pointcut("execution(public * spring.aspect.service.ComplexArithmetic.*(org.Spring.model.Complex, org.Spring.model.Complex))"
    		+ "&& args( a,  b)")
    public void cacheComplexResultAfteranOperation(Complex a, Complex b) {
    	
    }

    @Around("cacheComplexResultAfteranOperation(a, b)")
    public Object cacheAround(ProceedingJoinPoint jointPoint, Complex a, Complex b) throws Throwable {
    	
    	String key = a + ","+b;
    	
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
