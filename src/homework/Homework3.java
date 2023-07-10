package homework;

import java.util.Scanner;

public class Homework3 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Homework3 hw3 = new Homework3();

//		hw3.distinguishTriangle();
//		hw3.guessNumber();
		hw3.lotteryPickNum();
		sc.close();
	}
	// Q1
	public void distinguishTriangle() {
//		Scanner sc = new Scanner(System.in);
		int[] triangle = new int[3];
		String type = "";
		boolean isOther = true;
		boolean vertical = false;
		
		System.out.println("請輸入三個整數：");
		for (int i = 0; i < 3; i++) {
			triangle[i] = sc.nextInt();
		}
		int a = 0, b = 0, c = 0;
		for (int i = 0; i < 6; i++) {
			a = triangle[i % 3];
			b = triangle[(i + 1) % 3];
			c = triangle[(i + 2) % 3];
			
			if (a == 0 || b == 0 || c == 0) {
				type = "不是";
				isOther = false;
				break;
			} else if (a == b || a == c) {
				if (a == b && a == c) {
					type = "正";
					isOther = false;
					break;
				} else {
					type = "等腰";
					isOther = false;
					break;
				}
				
			} 
			if (a * a + b * b == c * c && a != 1) {
				vertical = true;
			}
		}
		
		if (isOther) {
			type = "其他";
		}
		
		if (vertical) {
			System.out.println(type + "直角三角形");
		} else {
			System.out.println(type + "三角形");
		}
		
	}
	
	// Q2
	public void guessNumber() {
		int answer = (int)(Math.random() * 101);
//		Scanner sc = new Scanner(System.in);
		System.out.println("開始猜數字吧！(0~100)");
		int guess = sc.nextInt();
		while (true) {
			if (guess == answer) {
				System.out.println("猜對了，答案是" + answer);
				break;
			}
			if (guess > answer) {
				System.out.println("猜錯囉．你猜的數字比答案大");
			} else {
				System.out.println("猜錯囉．你猜的數字比答案小");
			}
			guess = sc.nextInt();
		}

	}
	
	// Q3
	public void lotteryPickNum() {
		System.out.println("阿文...請輸入你討厭哪個數字？(1~9)");
		int unwanted = sc.nextInt();
		int[] choices = new int[49];
		for (int i = 0; i < 49 / 10; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i == unwanted || j == unwanted || i == 0 && j == 0) {
					continue;
				} else {
					int num = i * 10 + j;
						choice += 1;
						System.out.print(num + " ");
						
						}
				}	
			}
		}
		System.out.println(" " + "總共有" + choice +"個數字可選" );
	}
	
}
	
