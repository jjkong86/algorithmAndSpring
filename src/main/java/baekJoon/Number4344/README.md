## 문제풀이
 1. 평균은 넘겠지
 2. 평균 이상인 인원의 백분율을 구하는 문제
 3. 출력하는 포맷이 중요함
 
 
> ```
>  NumberFormat formatter = new DecimalFormat("#0.000");  
>  sb.append(formatter.format(avgRatio(input))+"%"+"\n");
>  System.out.printf("%.3f%%\n", result);
> ```

## 예제 입력
> ```
5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91
> ```

## Link
https://www.acmicpc.net/problem/4344

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>
