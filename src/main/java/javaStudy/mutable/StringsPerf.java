package javaStudy.mutable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StringsPerf {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		// With Buffer
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			executorService.execute(new AppendableRunnable<StringBuffer>(buffer));
		}
		shutdownAndAwaitTermination(executorService);
		System.out.println(" Thread Buffer : " + AppendableRunnable.time);

		// With Builder
		AppendableRunnable.time = 0;
		executorService = Executors.newFixedThreadPool(10);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			executorService.execute(new AppendableRunnable<StringBuilder>(builder));
		}
		shutdownAndAwaitTermination(executorService);
		System.out.println(" Thread Builder: " + AppendableRunnable.time);

	}

	static void shutdownAndAwaitTermination(ExecutorService pool) {
		pool.shutdown(); // code reduced from Official Javadoc for Executors
		try {
			if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
				pool.shutdownNow();
				if (!pool.awaitTermination(60, TimeUnit.SECONDS))
					System.err.println("Pool did not terminate");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
