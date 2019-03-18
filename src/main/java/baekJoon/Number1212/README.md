## 문제풀이
 1. 2진수 8진수
 2. 2진수를 8진수로 변환은 2진수를 3자리씩 끊어서 8진수로 만들어주면됨
 3. 수의 길이가 1,000,000 까지 이므로 8을 넘지 않는 수를 string으로 붙어야줘야함 
 4. 예외처리 필요
 
 
 
> ```
> (int) ((c - '0') * Math.pow(2, index));
> (index + 1) % 3 == 0
> ```

## 예제 입력
> 11001100

## Link
https://www.acmicpc.net/problem/1373

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>  
> codewars : https://www.codewars.com/users/jeongjeagong/stats
