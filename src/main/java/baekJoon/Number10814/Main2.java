package baekJoon.Number10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int number = Integer.parseInt(br.readLine());
			Person[] person = new Person[number];
			for (int i = 0; i < number; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int age = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				person[i] = new Person(i, age, name); 
			}
			Arrays.sort(person);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < person.length; i++) {
				Person p = person[i];
				sb.append(p.age).append(" ").append(p.name).append("\n");
			} 
			System.out.println(sb);
		}
	}
	
	public static class Person implements Comparable<Person> {
		int index;
		int age;
		String name;
		
		public Person(int index, int age, String name) {
			this.index = index;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person person) {
			int result = Integer.compare(this.age, person.age);
			if (result == 0) Integer.compare(this.index, person.index);
			return result;
//			if(this.age == person.age) return this.index - person.index;
//			else return this.age - person.age;
		}
	}
}
