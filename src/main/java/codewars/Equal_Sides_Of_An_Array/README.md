## 문제풀이
 1. Equal Sides Of An Array
 2. 배열 index를 기준으로 좌 우 합이 같으면 index를 리턴, 없으면 -1
 3. leftSum과  rightSum을 나눠서 더한뒤 비교함
 4. rightSum은 미리 더해두고 index가 증가함에 따라 빼줌(leftSum은 더해줌)
 
> ```
> leftSum += arr[i - 1];
> rightSum -= arr[i];
> ```

## Link
https://www.codewars.com/kata/equal-sides-of-an-array/train/java

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> codewars : <https://www.codewars.com/users/jeongjeagong>  
> leetCode : <https://leetcode.com/jjkong86/>
