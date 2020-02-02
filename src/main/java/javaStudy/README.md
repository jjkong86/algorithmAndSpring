1. 불변 객체와 가변객체의 비교(mutable vs imutable)
 - string은 불변 클래스이고 인스턴스가 생성될 때 초기화 되면 값을 수정할 수 없음
 - String 생성 : 리터럴 생성과 생성자를 통해 생성(내부적으로 intern() 메소드가 호출 > 상수 풀에 존재하는지 검색 > 없으면 생성하고 주소값 반환)
 - 불변타입의 장점
  1. Java에서 String 객체는 heap 영역의 String constant pool에서 따로 관리(불변이기 때문) > Java 7 이후는 heap 영역으로 이동(런타임 시 메모리 동적 확장 가능, gc대상이 됨)
  2. 멀티 쓰레드 환경에서 안전(thread-safe)
  3. 해시 코드 캐싱 : 불변이기 때문에 한번 계산하면 이후에 계산할 필요가 없음

 - 단점
  1. 불변 클래스이기 때문에 문자열을 연결 하면 연결된 새로운 문자열이 생기기 때문에 연산작업을 할 때 효율적이지 못함, 자바 8버전 이후부터 String 의 + 연산자를 통한 결합은 자바 컴파일러가 자동으로 StringBuilder로 변환해주고 있음 > 그러나 반복문 안에서는 변환해주지 않음
   - 반복문 안에서 문자열 결합을 하면 값이 변경되는것이 아니라 상수풀에 새로운 문자열 상수가 만들어지고 참조값이 새로운 상수를 바라보게됨, 속도가 StringBuilder에 비해 느림
 
2. StringBuilder, StringBuffer 비교
  1. StringBuffer는 append에서 동기화가 되어 있기 때문에 속도는 StringBuilder가 더 빠름
	- synchronized는 jvm에서 잠금을 획득하고 헤제 하는 과정이 추가 되기 때문에 더 느림
	
  ex) 멀티 쓰레드 환경에서 StringBuilder, StringBuffer 객체를 생성하고 각각의 쓰레드에 넘겨서 문자열을 결합하는 로직
  1. StringBuffer는 동기화가 되어있기 때문에 성공
  2. StringBuffer는 ArrayIndexOutOfBoundsException 발생
   - 문자열을 결합은 새로운 char[] 배열을 생성하고 이전값과 새로운 값을 추가함
   - 공간을 확보 한 뒤 -> 문자열을 추가하기전 서로 다른 쓰레드 접근 -> 하나의 쓰레드에서 작업 완료(문자열 길이 증가 : count), 다른 쓰레드에서 문자열을 결합 하려고 할 때 이미 증가된 문자열 index 뒤에 다시 복사하려고 하기 때문에 Exception 발생