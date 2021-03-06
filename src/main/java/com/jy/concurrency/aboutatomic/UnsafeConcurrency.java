package com.jy.concurrency.aboutatomic;

import com.jy.concurrency.annotion.ThreadUnsafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadUnsafe
public class ConcurrencyTest1 {
    /**
     * 请求数
     */
    private static int clientTotal = 5000;
    /**
     * 并发数
     */
    private static int threadTotal = 200;

    private static int count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("semaphore InterruptedException");
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            log.error("countDownLatch InterruptedException");
        }
        executorService.shutdown();
        log.info("count:{}",count);
    }

    public static void add(){
        count++;
    }
}
