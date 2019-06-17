## 문제풀이
 1. Shortest Unsorted Continuous Subarray
 2. 정렬되지 않은 하위 배열을 정렬하면 오름차순 정렬이 만족함, 중복된 수가 들어감
 3. 이때 가장 짧은 하위 배열의 length 
 4. 정렬을 이용하면 최적화가 안됨
 5. start index와 end index를 구하는 방식으로 하면 됨
 6. end의 경우 index 0부터 max값을 구한 뒤 max값 보다 작으면 end index를 저장
 
	int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	for (int i=0; i<nums.length; i++) {
		max = Math.max(nums[i], max);
		if (nums[i] < max) {
			end = i;
		}
	}

## 예제 입력

## Link
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>  
> codewars : https://www.codewars.com/users/jeongjeagong/stats
