## 문제풀이
 1. 나무 자르기
 2. 순차 접근하면 시간 초과 발생하므로 이분검색으로 접근해야 함
 3. 0 ~ 최대값의 중간값을 구해서 sum이 크고 작음에 따라서 최소값과 최대값을 변경해야함
 4. sum이 int 범위를 벗어나는것을 주의
 
 
> ```
> int middle = (left+right)/2;
> sum >= aim -> height = Math.max(height, middle); left = middle + 1;
> sum < aim -> right = middle -1;
> ```

## 예제 입력
4 7  
20 15 10 17

## Link
https://www.acmicpc.net/problem/2805

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>
