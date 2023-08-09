package homework.hw5;

import java.util.Scanner;

public class Homework5 {
//	static Scanner sc = new Scanner(System.in);
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Homework5 hw5 = new Homework5();
		
		// Q1
		System.out.println("請輸入寬與高：(請以空格或enter鍵隔開)");
		hw5.starSquare(hw5.sc.nextInt(), hw5.sc.nextInt()); 
		
		// Q2
		hw5.randAvg();
		
		// Q3
		int[][] intArray = { { 1, 6, 3 }, { 9, 5, 2 } };
		double[][] doubleArray = { { 1.2, 3.5, 2.2 }, { 7.4, 2.1, 8.2 } };
		System.out.println(hw5.maxElement(intArray));
		System.out.println(hw5.maxElement(doubleArray));
		
		// Q5
		System.out.println("本次隨機產生驗證碼為：" + hw5.genAuthCode());
		
	}
	// Q1
	public void starSquare(int width, int height) {
		for (int i = height; i > 0; i--) {
			for (int j = width; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	// Q2
	public void randAvg() {
		System.out.println("本次亂數結果：");
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int rand = (int) (Math.random() * 101);
			System.out.print(rand + " ");
			sum += rand;
		}
		System.out.println("\n" + (int) (sum / 10));
	}
	
	// Q3-1
	public int maxElement(int x[][]) {
		int max = x[0][0];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] > max) {
					max = x[i][j];
				}
			}
		}
		return max;
	}
	
	// Q3-2
	public double maxElement(double x[][]) {
		double max = x[0][0];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				if (x[i][j] > max) {
					max = x[i][j];
				}
			}
		}
		return max;
	}
	
	// Q5
	public String genAuthCode() {
		/**
		 * Returns a String with 8 random characters from A-Z, a-z and 0-9.
		 * This method generates the random characters by generating random integers
		 * between 0 and 61, and matching them to corresponding characters.
		 * e.g., 0: 0, 9: 9, A: 65, Z: 90, a: 97, z: 122
		 */
		String authCode = "";
		for (int i = 0; i < 8; i++) {
			char randCh = '0';
		
			int rd = (int) (Math.random() * 62);
			if (rd < 10) {
				randCh += rd;
			} else if (rd > 35) {
				randCh += rd + 13;
			} else {
				randCh += rd + 7;
			}			
			authCode += randCh;	
		}
		return authCode;
	}
}
