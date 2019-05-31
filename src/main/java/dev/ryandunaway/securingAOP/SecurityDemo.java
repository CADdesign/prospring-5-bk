package dev.ryandunaway.securingAOP;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityDemo {
    public static void main(String... args) {
        SecurityManager mgr = new SecurityManager();

        SecureBean bean = getSecureBean();

        mgr.login("John", "pwd");
        bean.writeSecureMessage();
        mgr.logout();
        try {
            mgr.login("invalid user", "pwd");
        }catch (SecurityException sec) {
            System.out.println("Exception caught: " + sec.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
    }

    private static SecureBean getSecureBean() {
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        return (SecureBean)factory.getProxy();
    }
}
