package xxx;
import java.util.Scanner;
public class TestBMI {
	public static void main(String[] args) {
//		double weight = 60;
//		double height = 1.63;
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入體重(kg)：");
		double weight = Double.parseDouble(scanner.nextLine());
		System.out.println("輸入身高(m)：");
		double height = Double.parseDouble(scanner.nextLine());
		double bmi = weight / Math.pow(height, 2);
		
		if (bmi < 18.5) {
			System.out.printf("BMI為%.3f，過瘦%n", bmi);
		} else if (bmi < 24) {
			System.out.printf("BMI為%.3f，正常%n", bmi);
		} else {
			System.out.printf("BMI為%.3f，過胖%n", bmi);
		}
		
		scanner.close();
	}

}
