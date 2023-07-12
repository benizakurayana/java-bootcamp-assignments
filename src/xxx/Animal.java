package xxx;

public class Animal {
	int age;
	float weight;
	
	public Animal(int age, float weight) {
		this.age = age;
		this.weight = weight;
	}
	
	public void speak() {
		System.out.printf("Age: %d\nWeight: %.2f\n", age, weight);
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public int getAge() {
		return age;
	}

	public float getWeight() {
		return weight;
	}
}
