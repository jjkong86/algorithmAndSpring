## 문제풀이
 1. 버블 정렬하여 정렬 횟수를 구하는 문제
 2. 2시간 제한은 2초, 개수는 500,000개 이하 이므로 o(n2)방식으로는 시간 초과 하게됨
 3. 정렬 숫자는 최초 자리에서 앞으로 이동한 것 중 이동 횟수가 가장 많은 숫자를 구하면됨
 4. 숫자를 Pair 객체에 담아서 최초 위치한 index를 부여함
 5. 그리고 정렬 후의 index와 최초 부여된  index를 비교하여 가장 큰 수를 찾으면됨
 
 
 
> ```
> if (max < list.get(i).index - i) {
>  max = list.get(i).index - i;
> }
> ```

## 예제 입력
5  
10  
1  
5  
2  
3  

## Link
https://www.acmicpc.net/problem/1377

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>  
> codewars : https://www.codewars.com/users/jeongjeagong/stats
