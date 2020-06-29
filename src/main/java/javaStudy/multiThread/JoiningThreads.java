package javaStudy.multiThread;

import java.util.concurrent.TimeUnit;

public class JoiningThreads {
	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "]" + " thread starts here...");

		Thread thread1 = new Thread(new LoopTask(200), "Thread-1");
		Thread thread2 = new Thread(new LoopTask(500), "Thread-2");
		Thread thread3 = new Thread(new LoopTask(100), "Thread-3");

		thread1.start();
		thread2.start();
		thread3.start();

		thread1.join();
		System.out.println("[" + currentThreadName + "]" + " joined " + thread1.getName());

		thread2.join();
		System.out.println("[" + currentThreadName + "]" + " joined " + thread2.getName());

		thread3.join();
		System.out.println("[" + currentThreadName + "]" + " joined " + thread3.getName());

		System.out.println("[" + currentThreadName + "]" + " thread ends here...");
	}
}

class LoopTask implements Runnable {
	private static int count = 0;
	private int id;
	private long sleepTime;
	private String taskId;

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("#### <" + currentThreadName + "," + taskId + "> starting...####");
		for (int i = 0; i < 4; i++) {
			System.out.println("<" + currentThreadName + "," + taskId + "> TICK TICK");
			try {
				TimeUnit.MILLISECONDS.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(currentThreadName + " time sleep : " + (System.currentTimeMillis() - startTime));
		System.out.println("#### <" + currentThreadName + "," + taskId + "> done...####");
	}

	public LoopTask(long sleepTime) {
		this.id = ++count;
		this.taskId = "Task-" + id;
		this.sleepTime = sleepTime;
	}
}
