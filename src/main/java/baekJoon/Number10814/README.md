## 문제풀이
 1. 나이순 정렬
 2. 숫자와 문자열을 조합한 정렬임으로 각각의 배열 객체를 생성하여 저장하고 서로 같은 인덱스를 줌
 3. 숫자 배열을 정렬하고 숫자 배열의 인덱스로 문자 배열을 찾아 들어가서 조합함
 4. 다른 방법으로 클래스를 만들어서 Comparable를 구현하고 compareTo를 재정의함
 5. 마찬가지로 각각의 객체에는 인덱스가 들어가야 나이가 같을때 정렬이 가능함
 
 
> ```
> Arrays.sort(array, new Comparator<int[]>() {
> 	public int compare(int[] o1, int[] o2) {
> 	}
> });
> ```

> ```
> @Override
> public int compareTo(Person person) {
> 	if(this.age == person.age) return this.index - person.index;
> 	else return this.age - person.age;
> }
> ```

## 예제 입력
3  
21 Junkyu  
21 Dohyun  
20 Sunyoung  

## Link
https://www.acmicpc.net/problem/10814

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> leetCode : <https://leetcode.com/jjkong86/>  
> codewars : https://www.codewars.com/users/jeongjeagong/stats



