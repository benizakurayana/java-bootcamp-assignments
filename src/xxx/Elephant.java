package xxx;

public class Elephant extends Animal{
	String name;
	
	public Elephant() {
		
	}
	
	public Elephant(int age, float weight, String name) {
		super(age, weight);
		this.name = name;
	}
	
	@Override  // @ Annotation(標註)：給開發工具(Java compiler)或框架(framework)看的資訊
			   // 請compiler用override的規則去檢查此method，以免被它誤認為是overloading而沒有報錯 (安全)
	public void speak() {
		super.speak();
		System.out.printf("Name: %s\n", name);
	}
	
//      編譯成功, 但不符合override規則
//      因為被編譯器當成overloading, 1個是speak() (Animal) 1個是speak(int data) (Elephant)
//		public void speak(int data) {
//			super.speak();
//			System.out.println("Name is = " + name);
//		}
	
	
	public static void main(String[] args) {
		Animal ani1 = new Animal(3, 8.0f);
		Elephant elephant1 = new Elephant(8, 1200.0f, "elephant");
		ani1.speak();
		elephant1.speak();
	}
}
