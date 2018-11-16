package dataStructure;

public class Main {
	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
	    numbers.addLast(20);
	    numbers.addLast(30);
	    numbers.addLast(40);
	    
	    numbers.add(1, 15);
	    
	    numbers.addLast(50);
	    numbers.addFirst(5);
	    numbers.addLast(30);
	    
	    numbers.removeIndex(3);
	    
	    numbers.removeElement(30);
	    
	    System.out.println(numbers.printString());
	}
}
