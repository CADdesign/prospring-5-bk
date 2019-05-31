package dev.ryandunaway.securingAOP;

/**
 * This is a very basic class that CLEARLY should NOT be used in production.  This is for my understanding only!
 */


public class SecurityManager {

    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<UserInfo>();

    public void login(String userName, String password) {
        threadLocal.set(new UserInfo(userName, password));
    }

    public void logout(){
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser(){
        return threadLocal.get();
    }
}
