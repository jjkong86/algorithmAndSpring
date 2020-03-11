package javaStudy.multiThread;

public class JoinExample {
	public static void main(String[] args) {
		int result = 0;
		for (int i = 0; i < 2; i++) {

			SumThread sumThread = new SumThread();
			sumThread.start();

			try {
				sumThread.join(); // sumThread가 종료될때까지 메인 스레드를 정지시킴
				result += sumThread.getSum();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("1 ~ 100까지의 합 : " + result);
	}
}
