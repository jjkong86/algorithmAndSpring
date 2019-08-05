package etc;

import java.util.*;

import javax.swing.JOptionPane;

public class Test7 {
	
	public static class Cup {
		int size;
		
		public Cup(int i) {
			this.size = i;
		}
		
		public int getSize() {
			return size;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("1234".split(" ").length);
		String input = JOptionPane.showInputDialog("아무거나");
		System.out.println(input);
	}
}
