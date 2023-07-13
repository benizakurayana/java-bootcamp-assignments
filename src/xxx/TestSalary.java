package xxx;

public class TestSalary {
	public static void main(String[] args) {
		FullTimeEmployee tin = new FullTimeEmployee(2001, "Tin", 100000);
		Manager lawrence = new Manager(101, "Larence", 200000, 50000);
		
		// 應該要用override，在Employee定義一個getSalary()，於各sub class override為各自適用的getSalary()
		System.out.println(tin.getFullTimeSalary());
		System.out.println(lawrence.getManagerSalary());
	}
}
