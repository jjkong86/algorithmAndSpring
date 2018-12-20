package bookAlgorithms.sort;

import java.util.Random;

public class worstBestLinearSelect {
	
	private static int[] wArray;
	
	public static void main(String[] args) {
		Random gen =  new Random();
		int[] array = new int[10];
		int targetIndex = 0;
		for (int i = 0; i < 10; i++) {
			array[i] = gen.nextInt(100);
			targetIndex = targetIndex != 0? targetIndex : gen.nextInt(10);
		}
		System.out.println("targetIndex : "+targetIndex);
		wArray = array;
		int result = select(0, wArray.length -1, targetIndex);
		System.out.println("result : " + result);
		
	}
	
	public static int linearSelct(int start, int end, int targetIndex) {
		//총 원소가 5개 이하이면 targetIndex 번째 원소를 찾고 알고리즘을 끝냄
		//전체 원소를 n/5나눔 -> 각 그룹에서 중앙값 찾음 -> 그 중앙값들의 중앙값을 찾음(재귀적으로) -> 홀수이면 1개, 짝수이면 2개중 임으로 선택
		//최종 중앙값을 기준으로 작은값과 큰값을 분할 -> 재귀적으로 반복하여 최종값 찾아야함
		if (wArray.length <= 5) {
			int select = select(start, end, targetIndex);
			return select;
		}
		return 0;
	}
	
	public int middleFind(int start, int end) {
		
		for (int i = 1; i < wArray.length; i*=5) {
			int subMiddle = select(i, i*5, i*5/2);
		}
		
		return 0;
	}
	
	public static int select(int start, int end, int targetIndex) {
		if (start >= end) {
			return wArray[start];
		}
		
		int partition = partition(start, end);
		if (targetIndex == partition) {
			return wArray[targetIndex];
		} else if (targetIndex < partition) {
			select(start, partition - 1, targetIndex);
		} else if (targetIndex > partition){
			select(partition + 1, end, targetIndex);
		}
		
		return wArray[targetIndex];
	}
	
	public static int partition(int start, int end) {
		int target = wArray[end];
		System.out.println("==============================");
		System.out.println("==============================");
		System.out.println("target : "+target);
		int firstIndex = start;
		
		for (int thirdIndex = start; thirdIndex < end; thirdIndex++) {
			if (wArray[thirdIndex] < target) {
				int temp = wArray[thirdIndex];
				wArray[thirdIndex] = wArray[firstIndex];
				wArray[firstIndex++] = temp;
			}
		}
		
		wArray[end] = wArray[firstIndex];
		wArray[firstIndex] = target;
		System.out.println("partition : "+firstIndex);
		print(wArray);
		
		return firstIndex;
	}
	
	public static void print(int[] array) {
		StringBuilder print = new StringBuilder("정렬 후 : ["+array[0]+", ");
		for (int j = 1; j < array.length; j++) {
			print.append(array[j]).append(j == array.length-1 ? "" : ", ");
		}
		System.out.println(print+"]");
	}
}
