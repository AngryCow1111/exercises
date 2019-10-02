package com.ac.concurrency.threadpool;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

/**
 * CustomizedThreadPool
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/2
 */
public class CustomizedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5, 1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executorService.execute(() -> {
                System.out.println("当前运行的线程为:" + Thread.currentThread().getName() + ",data为：" + temp);
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            });
        }

    }
}
