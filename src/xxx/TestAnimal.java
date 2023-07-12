package xxx;

public class TestAnimal {
	public static void main(String[] args) {
		Animal myAnimal = new Animal(5, 1.2f);
		myAnimal.speak();
		
		myAnimal.setAge(6);
		myAnimal.setWeight(1.9f);
		myAnimal.speak();
	}
}
