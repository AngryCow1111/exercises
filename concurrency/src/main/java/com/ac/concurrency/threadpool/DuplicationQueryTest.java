package com.ac.concurrency.threadpool;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DuplicationQueryTest
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/10/17
 */
public class DuplicationQueryTest {
    static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                6, 10, 2,
                TimeUnit.SECONDS, new ArrayBlockingQueue(10));

        List list1 = new ArrayList(10);
        queryList(list1, false, executor);
        List list2 = new ArrayList(10);
        queryList(list2, false, executor);
        List list3 = new ArrayList(10);
        queryList(list3, true, executor);
        List list4 = new ArrayList(10);
        queryList(list4, false, executor);
        List list5 = new ArrayList(10);
        queryList(list5, false, executor);
        try {
            countDownLatch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕.......");

    }


    private static void queryList(List list, boolean isLazy, ThreadPoolExecutor executor) {
        executor.execute((() -> {

            for (Object o : list) {
                System.out.println("当前的遍历的对象是：" + o.toString());
            }
            if (isLazy) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countDownLatch.countDown();
        }));


    }


}
