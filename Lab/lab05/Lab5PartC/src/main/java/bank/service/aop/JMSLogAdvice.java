package bank.service.aop;

import bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Aspect
@Configuration
public class JMSLogAdvice {
    @Autowired
    private ILogger iLogger;

    @After("execution(* bank.jms.JMSSender.sendJMSMessage(..)) && args(msg)")
    public void logJMSMessage(JoinPoint joinPoint, String msg){
        System.out.println("Message sent log: " +msg);
    }

}
