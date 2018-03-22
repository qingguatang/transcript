package demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodMonitor {

  @Around("execution(* demo.*.*(..))")
  public Object proceed(ProceedingJoinPoint pjp) throws Throwable {
    long last = System.currentTimeMillis();

    Object retVal = pjp.proceed();

    long now = System.currentTimeMillis();
    System.err.println(pjp.getSignature().toString() + " invoke use " + (now - last) + "ms");

    return retVal;
  }

}
