## 문제풀이
 1. Top K Frequent Words
 2. 문자열과 리턴될 문자열 수가 주어지면 가장 많이 반복되는 문자열을 리턴함
 3. 반복되는 문자열을 map에 넣어두고 value를 역순으로 정렬함
 4. value가 같으면 key를 기준으로 다시 정렬함
 
	private Comparator<Map.Entry<String, Integer>> sortByValueAndKey() {
			return (Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) -> a.getValue() == b.getValue()
					? a.getKey().compareTo(b.getKey())
					: b.getValue().compareTo(a.getValue());
	}
	
	map.entrySet().stream().sorted(sortByValueAndKey()).limit(k).forEachOrdered(x -> list.add(x.getKey()));
 
## Link
https://leetcode.com/problems/top-k-frequent-words/

## MyAccount

> backjoon : <https://www.acmicpc.net/user/jjkong86>  
> codewars : <https://www.codewars.com/users/jeongjeagong>  
> leetCode : <https://leetcode.com/jjkong86/>
