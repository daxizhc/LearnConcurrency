package com.tony.learnconcurrency.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizeExample {

    public static void test1(int j){
        synchronized (SynchronizeExample.class){
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizeExample synchronizeExample1 = new SynchronizeExample();
        SynchronizeExample synchronizeExample2 = new SynchronizeExample();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            synchronizeExample1.test1(1);
        });
        executorService.execute(() -> {
            synchronizeExample2.test2(2);
        });

    }

}
