package test.hiperConnect;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Entry {
	Queue<String> q = new LinkedList<>();

	public void enter(String passportNumber) {
		if (passportNumber != null || !"".equals(passportNumber)) {
			q.offer(passportNumber);
		}
	}

	public String leave() {
		if (q.isEmpty())
			throw new UnsupportedOperationException("Waiting to be implemented.");
		return q.poll();
	}

	public static void main(String[] args) throws IOException {
		Entry entry = new Entry();
		entry.enter("AB54321");
		entry.enter("UK32032");
		System.out.println(entry.leave());
		System.out.println(entry.leave());
		System.out.println(entry.q.isEmpty());
	}
}
