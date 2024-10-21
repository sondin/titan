package com.ai.titan.aop;

public class ProxySubject implements Subject{

    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void operation() {
        beforeOperation();
        realSubject.operation();
        afterOperation();
    }

    private void beforeOperation() {
        System.out.println("Before operation.");
    }

    private void afterOperation() {
        System.out.println("After operation.");
    }
}
