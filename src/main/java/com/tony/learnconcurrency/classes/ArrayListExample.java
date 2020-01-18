package com.tony.learnconcurrency.classes;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@SuppressWarnings("Duplicates")
public class ArrayListExample {

    static int clientTotal = 5000;

    static int threadTotal = 200;

    static ArrayList arrayList = new ArrayList();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("error", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", arrayList.size());
        log.info("list:{}", arrayList);
    }

    private static void add(int i){
        arrayList.add(i);
    }

}
