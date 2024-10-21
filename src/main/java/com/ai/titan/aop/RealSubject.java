package com.ai.titan.aop;

public class RealSubject implements  Subject{
    @Override
    public void operation() {
        System.out.println("Real operation.");
    }
}
