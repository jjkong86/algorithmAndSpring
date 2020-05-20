package javaStudy.multiThread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiTreadTest {

    private static BlockingQueue<Integer> makeQueue() {
        BlockingQueue<Integer> SupplyQueue = new LinkedBlockingDeque<>();
        int maxEseq = 7323817, minEseq = 1280646, copy = minEseq, chunk = 100;

        while (copy < maxEseq) {
            SupplyQueue.offer(copy += chunk);
        }
        return SupplyQueue;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int num = 11;
        BlockingQueue<Integer> SupplyQueue = makeQueue();
        System.out.println(SupplyQueue.size());
        System.out.println(SupplyQueue.toString());

        ExecutorService e = Executors.newFixedThreadPool(num);
        StringBuffer sb = new StringBuffer();

        AtomicBoolean success = new AtomicBoolean(true);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < num; i++) {
            Future<?> f = e.submit(() -> {
                try {
                    while (!SupplyQueue.isEmpty()) {
                        Integer pagingNum = SupplyQueue.poll();
                        count.incrementAndGet();
//                        sb.append(Thread.currentThread().getName()).append(", paging Num : ").append(pagingNum).append(", ");
                        sb.append(pagingNum).append(", ");
//                        Thread.sleep(1000);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    success.set(false);
                }
            });
            f.get();
        }
        if (!e.isShutdown())
            e.shutdown();

        System.out.println("SupplyQueue size + " + SupplyQueue.size());
        System.out.println(count.intValue());
//        System.out.println(sb);
    }
}
