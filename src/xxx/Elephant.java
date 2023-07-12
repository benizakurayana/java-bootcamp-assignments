package xxx;

public class Elephant extends Animal{
	String name;
	
	public Elephant(int age, float weight, String name) {
		super(age, weight);
		this.name = name;
	}
	
	public void speak() {
		super.speak();
		System.out.printf("Name: %s\n", name);
	}
	
	public static void main(String[] args) {
		Animal ani1 = new Animal(3, 8.0f);
		Elephant elephant1 = new Elephant(8, 1200.0f, "elephant");
		ani1.speak();
		elephant1.speak();
	}
}
