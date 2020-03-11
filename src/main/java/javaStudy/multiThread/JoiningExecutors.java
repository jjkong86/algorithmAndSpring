package javaStudy.multiThread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class JoiningExecutors {
	public static void main(String argc[]) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "]" + " thread starts here...");
		ExecutorService execService1 = Executors.newCachedThreadPool(new NamedThreadsFactory());
		CountDownLatch doneSignal = new CountDownLatch(4); // set the initial count

		execService1.execute(new LoopTask1(doneSignal));
		execService1.execute(new LoopTask1(doneSignal));
		execService1.execute(new LoopTask1(doneSignal));
		execService1.execute(new LoopTask1(doneSignal));

		execService1.shutdown();

		try {
			doneSignal.await(); // wait for the count = 0
			System.out.println("[" + currentThreadName + "]" + " got the signal to continue...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("[" + currentThreadName + "]" + " thread ends here...");
	}
}

class NamedThreadsFactory implements ThreadFactory {

	private static int count = 0;
	private static String Name = "MyThread-";

	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r, Name + ++count);
	}
}

class LoopTask1 implements Runnable {
	private static int count = 0;
	private int id;
	private String taskId;
	private CountDownLatch doneCountLatch;

	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("#### <" + currentThreadName + "," + taskId + "> starting...####");
		for (int i = 0; i < 5; i++) {
			System.out.println("<" + currentThreadName + "," + taskId + "> TICK TICK" + i);
			try {
				TimeUnit.MILLISECONDS.sleep((long) Math.random() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#### <" + currentThreadName + "," + taskId + "> done...####");
		if (doneCountLatch != null) {
			doneCountLatch.countDown(); // count--
			System.out.println(
					"#### <" + currentThreadName + "," + taskId + "> LATCH COUNT =" + doneCountLatch.getCount());
		}
	}

	public LoopTask1(CountDownLatch doneCountLatch) {
		this.id = ++count;
		this.taskId = "LoopTask" + id;
		this.doneCountLatch = doneCountLatch;
	}
}
