package etc;

public class BinarySearch {

	public static int findTarget(int[] array, int target) {
		int result = -1;
		int left = 0, right = array.length - 1;

		while (right >= left) {
			int mid = (right + left) / 2;
			int temp = array[mid];

			System.out.println("mid index : " + mid + ", value : " + temp + ", left : " + left + ", right : " + right);
			if (target == temp) {
				return mid;
			} else if (target > temp) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 8, 9, 16, 128 };
		System.out.println(findTarget(array, 1));
		System.out.println(findTarget(array, 2));
		System.out.println(findTarget(array, 8));
		System.out.println(findTarget(array, 9));
		System.out.println(findTarget(array, 16));
		System.out.println(findTarget(array, 128));
		System.out.println(findTarget(array, 7));
	}
}
