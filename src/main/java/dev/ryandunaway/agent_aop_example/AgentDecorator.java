package dev.ryandunaway.agent_aop_example;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("James");
        Object retValue = methodInvocation.proceed();
        System.out.println("!");
        return retValue;
    }
}
