package javaStudy.multiThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchTest {
	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		AtomicInteger ordinal = new AtomicInteger(0);
		for (int i = 0; i < 20; i++) {
			reentrantLock.lock();
			Thread thread = new Thread() {
				@Override
				public void run() {
					for (int i = 0; i < 10; i++) {
						ordinal.getAndIncrement();
					}
				}
			};
			thread.start();
			reentrantLock.unlock();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(ordinal.get());
	}

}
