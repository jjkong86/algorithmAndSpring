package javaStudy.multiThread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiTreadTest {

    private static BlockingQueue<Integer> makeQueue() {
        BlockingQueue<Integer> SupplyQueue = new LinkedBlockingDeque<>();
        int maxEseq = Integer.MAX_VALUE/1000, minEseq = 1, copy = minEseq; //7323806

        while (copy < maxEseq) {
            SupplyQueue.offer(copy += 1);
        }
        return SupplyQueue;
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 11;
        BlockingQueue<Integer> supplyQueue = makeQueue();
        System.out.println(supplyQueue.size());
        System.out.println(supplyQueue.toString());

        ExecutorService executorService = Executors.newFixedThreadPool(num);

        AtomicBoolean success = new AtomicBoolean(true);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < num; i++) {
            executorService.execute(() -> {
                try {
                    while (!supplyQueue.isEmpty()) {
                        Integer pagingNum = supplyQueue.poll();
                        count.incrementAndGet();
//                        sb.append(Thread.currentThread().getName()).append(", paging Num : ").append(pagingNum).append(", ");
//                        Thread.sleep(1000);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    success.set(false);
                }
            });
        }
        while (true) {
            System.out.println("tread sleep : " + System.currentTimeMillis());
            Thread.sleep(1000);
            if (supplyQueue.isEmpty()) {
                executorService.shutdown();
                try {
                    if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executorService.shutdownNow();
                    break;
                }

                break;
            }
        }

        System.out.println("SupplyQueue size + " + supplyQueue.size());
        System.out.println(count.intValue());
//        System.out.println(sb);
    }
}
