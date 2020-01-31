package etc.mutiThead;

import java.io.IOException;

class AppendableRunnable<T extends Appendable> implements Runnable {

	static long time = 0;
	T appendable;

	public AppendableRunnable(T appendable) {
		this.appendable = appendable;
	}

	@Override
	public void run() {
		long t0 = System.currentTimeMillis();
		for (int j = 0; j < 10000; j++) {
			try {
				appendable.append("some string");
			} catch (IOException e) {
			}
		}
		time += (System.currentTimeMillis() - t0);
	}
}
