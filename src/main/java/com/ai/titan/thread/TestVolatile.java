package com.ai.titan.thread;

import java.util.concurrent.TimeUnit;

public class TestVolatile {

    private static volatile boolean stop = false;

    public  void main1(String[] args) {
        // Thread-A
        new Thread("Thread A") {
            @Override
            public void run() {
                while (!stop) {
                }
                System.out.println(Thread.currentThread() + " stopped");
            }
        }.start();

        // Thread-main
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread() + " after 1 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
    }


    public class Base {
        private void test() {
        }
    }

    public class Son extends Base{
        public void test() {
        }

    }

    public static void main(String[] args) {
        Son son = new Son();
        Base father = son;
        //father.test();
    }
}
