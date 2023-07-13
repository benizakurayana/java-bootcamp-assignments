package xxx;

public class Animal {
	int age;
	float weight;
	
	// 保留著無參數建構子
	public Animal() {
		// 1. 給子類別的對應
		// 2. 給日後搭配的工具(框架framework)使用, 框架會利用此建構子幫我們建立物件
	}
	
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
