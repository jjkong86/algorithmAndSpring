package animal;

public class PlayAnimal {
	public static void main(String[] args) {
		Animal eagle = new Eagle();
		eagle.performFly();
		
		Animal tiger = new Tiger();
		tiger.performCry();
	}
}
