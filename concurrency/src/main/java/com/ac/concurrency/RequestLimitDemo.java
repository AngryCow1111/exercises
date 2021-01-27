package com.ac.concurrency;

import java.util.*;
import java.util.concurrent.*;

/**
 * RequestLimitDemo
 *
 * @author <a href="mailto:yanghui@it.gongmall.com">yanghui</a>
 * @since 2020/4/1
 */
public class RequestLimitDemo {

    private static Semaphore s = new Semaphore(8); // 16个停车位
    private static Map<String, Integer> accountMap = new LinkedHashMap<>();
    private static int countPerAccount = 4;
    private static int count = 0;
    private static List<String> accountList = Arrays.asList("001", "002", "003", "004");
    public static ExecutorService executorService = new ThreadPoolExecutor(2,
            5, 1,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    private static void init() {
        accountMap.put("001", 2);
        accountMap.put("002", 2);
        accountMap.put("003", 2);
        accountMap.put("004", 2);
    }

    public static void fetchAccount() {
        String account = null;
        try {
            s.acquire();
            account = getAccount();
        } catch (InterruptedException e) {
        } finally {
            s.release();
            releaseAccount(account);
        }
    }

    public static synchronized String getAccount() {
        while (true) {
            int index = count++ % accountList.size();
            String accountKey = accountList.get(index);
            Integer count = accountMap.get(accountKey);
            System.out.println("账号:" + accountKey + "次数:" + count);
            if (count > 0) {
                count--;
                accountMap.put(accountKey, count);
                return accountKey;
            }
        }
    }

    public static synchronized String releaseAccount(String accountKey) {
        Integer count = accountMap.get(accountKey);
        accountMap.put(accountKey, count++);
        return accountKey;
    }

    public static void main(String[] args) {
        init();
        executorService.execute(() -> {
            for (int i = 0; i < 20; i++) {
                fetchAccount();
            }
        });

        executorService.execute(() -> {
            for (int i = 0; i < 20; i++) {
                fetchAccount();
            }
        });

        executorService.execute(() -> {
            for (int i = 0; i < 20; i++) {
                fetchAccount();
            }
        });
    }
}
