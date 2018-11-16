package animal;

import animal.cry.Cry;
import animal.fly.Fly;

public abstract class Animal {
	protected Fly fly;
	
	protected Cry cry;
	
	public Animal() {
		
	}
	
	public void performFly() {
		fly.fly();
	}
	public void performCry() {
		cry.cry();
	}
}
