## 문제풀이
 1. Best Time to Buy and Sell Stock with Cooldown
 2. int[] buy = i-1번째에서 사는것과 i-2에 팔고 i번째에서 사는것 중 큰 값
 3. int[] sell = i-1번째에서 판것(대기하는것)과 i-1번째 에서 산것을 판 값중 큰 값 
 
	buy[i] = Math.max(buy[i - 1], sell[i - 2] - price);
	sell[i] = Math.max(sell[i - 1], buy[i - 1] + price);

## 예제 입력

## Link
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>  
> codewars : https://www.codewars.com/users/jeongjeagong/stats
