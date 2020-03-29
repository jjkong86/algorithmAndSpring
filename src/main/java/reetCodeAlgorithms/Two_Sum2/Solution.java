package reetCodeAlgorithms.Two_Sum2;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // target = numbers[index1] + numbers[index2];
        // 주어진 배열은 오름차순으로 정렬 되어 있음.
        int left = 0, right = numbers.length - 1;
        while (right > left) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) break;
            else if (sum > target) right--;
            else left++;
        }

        return new int[]{left + 1, right + 1};
    }
}
