## 문제풀이
 1. Product of consecutive Fib numbers
 2. 피보나치 함수를 구하고, F(n) * F(n+1) 되는 숫자면 true를 반환
 3. F(n) * F(n+1) < prod < F(n+1) * F(n+2) 라면 F(n+1), F(n+2), false 반환
 
	while (a * b < prod) {
		long temp = a;
		a = b;
		b = temp + b; 
	}

## Link
https://www.codewars.com/kata/5541f58a944b85ce6d00006a

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> codewars : <https://www.codewars.com/users/jeongjeagong>  
> leetCode : <https://leetcode.com/jjkong86/>
