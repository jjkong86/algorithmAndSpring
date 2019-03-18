## 문제풀이
 1. 암호코드 : A를 1이라고 하고, B는 2로, 그리고 Z는 26으로
 2. 0으로 들어올때와 26을 넘을때 예외 처리 해야함
 
> ```
> dp[i] = dp[i-1] + dp[i-2]
> char 두 문자를 숫자로 만드는 방법
> int sumNumber = Integer.parseInt(Character.toString(charArray[i-2]) + Character.toString(charArray[i-1]));
> ```

## 예제 입력
25114

## Link
https://www.acmicpc.net/problem/2011

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>  
> codewars : https://www.codewars.com/users/jeongjeagong/stats
