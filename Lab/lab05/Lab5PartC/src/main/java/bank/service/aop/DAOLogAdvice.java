package bank.service.aop;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
@Aspect
@Configuration
public class DAOLogAdvice {
    @Autowired
    private ILogger logger;

    @Before("execution(* bank.dao.*.*(..))")
    public void logDAOCall(JoinPoint joinPoint){
        System.out.println("Call of the method " + joinPoint.getSignature().getName());
    }




}
