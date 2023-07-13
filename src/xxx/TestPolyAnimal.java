package xxx;

public class TestPolyAnimal {
	public static void main(String[] args) {
	Animal a1 = new Animal(3, 8.0f);
	Animal a2 = new Elephant(20, 100.0f, "ele");
	a1.speak();
	a2.speak();
	}
}
