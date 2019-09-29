package etc.joy;
class Person extends FullAbstract {

	@Override
	public void drinkWater() {
		System.out.println("Drink water");
	}

	@Override
	public void walk() {
		System.out.println("Person walks");
	}

	@Override
	public boolean isLiquid() {
		return false;
	}

	public static void main(String[] args) {
		System.out.println(IsLiquid.A);
	}
}
