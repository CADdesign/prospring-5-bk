package dev.ryandunaway.methodBeforeAdvice;

public class Guitarist implements Singer {
    private String lyric = "You're gonna live forever in me.";

    public void sing() {
        System.out.println(lyric);
    }
}
