package xxx;

public class Student {
	int score = 90;
	
	public void play(int hours) {
		score -= hours;
	}
	
	public void study(int hours) {
		score += hours;
	}
	
	public static void main(String[] args) {
		Student ian = new Student();
		Student josh = new Student();
		System.out.println(ian.score);
		System.out.println(josh.score);
		
		ian.play(5);
		System.out.println(ian.score);
		ian.study(10);
		System.out.println(ian.score);
		
		josh.play(10);
		System.out.println(josh.score);
		josh.study(5);
		System.out.println(josh.score);
	}
}
