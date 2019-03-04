## 문제풀이
 1. The Supermarket Queue
 2. n : 주문을 받을 수 있는 카운터 수
 3. 카운터가 모두 주문 중 이라면 순서대로 대기 하다가 주문 끝난 카운터로 감
 
> ```
>  int [] result = new int [n];
> 	    for (int i : customers) {
> 	        Arrays.sort(result);
> 	        result[0] += i;
> 	    }
> ```

## Link
https://www.codewars.com/kata/the-supermarket-queue/train/java

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> codewars : <https://www.codewars.com/users/jeongjeagong>  
> leetCode : <https://leetcode.com/jjkong86/>
