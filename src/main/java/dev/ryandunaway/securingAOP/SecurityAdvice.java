package dev.ryandunaway.securingAOP;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Optional;

public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }


    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Optional<UserInfo> user = Optional.ofNullable(securityManager.getLoggedOnUser());
        if (!user.isPresent()) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
        } else if ("John".equals(user.get().getUserName())){
            System.out.println("logged in user is John -- OKAY!");
        } else {
            System.out.println("Logged in user is " + user.get().getUserName() + " NOT GOOD :(");
            throw new SecurityException("User " + user.get().getUserName() + " is not allowed access to method " +
                    method.getName());
        }
    }
}
