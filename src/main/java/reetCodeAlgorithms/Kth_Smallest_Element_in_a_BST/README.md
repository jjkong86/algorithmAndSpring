## 문제풀이
 1. Kth Smallest Element in a BST
 2. k번째 작은 숫자를 찾아야함(2진탐색)
 3. root를 기준으로 왼쪽은 작은 수, 오른쪽은 큰수이기 때문에 root.left의 엘리먼트 수를 구해서 처리 
 4. k<=count면 왼쪽에 원하는 k번째 숫자가 있음, 반대면 k-1-count번째가 오른쪽에 있음
 
	if (node == null) return 0;
	return 1 + countNodes(node.left) + countNodes(node.right);

## 예제 입력

## Link
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>  
> codewars : https://www.codewars.com/users/jeongjeagong/stats
