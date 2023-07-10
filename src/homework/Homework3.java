package homework;

import java.util.Arrays;
import java.util.Scanner;

public class Homework3 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework3 hw3 = new Homework3();

		hw3.distinguishTriangle();
		hw3.guessNumber();
		hw3.lotteryPickNum();
		sc.close();
	}

	// Q1
	public void distinguishTriangle() {

		int[] triangle = new int[3];
		String type = "";
		boolean vertical = false;

		System.out.println("請輸入三個整數：");
		for (int i = 0; i < 3; i++) {
			triangle[i] = sc.nextInt();
		}

		int a = 0, b = 0, c = 0;
		for (int i = 0; i < 3; i++) {
			// To ensure each element in the array is compared with all the others.
			a = triangle[i % 3];
			b = triangle[(i + 1) % 3];
			c = triangle[(i + 2) % 3];

			// Check triangle type: not a triangle, equilateral(正三角形) or isosceles(等腰三角形)
			// If it's none of the above, then it's an "other" type.
			if (a == 0 || a + b <= c || Math.abs(a - b) >= c) {
				type = "不是";
				break;
			} else if (a == b) {   
				// Definition of an isosceles triangle: it has two sides of equal length.
				// It's notable that an equilateral triangle is theoretically also a special case of an isosceles one.
				// Therefore, we shall place the condition of the former before the latter.
				if (a == b && a == c) {
					type = "正";
					break;
				} 
				type = "等腰";
				break;
			}
			
			// Check if it's a right triangle(直角三角形) by Pythagorean theorem(畢氏定理)
			if (a * a + b * b == c * c) {
				vertical = true;
			}
		}
		// If none of the conditions above is fulfilled, the type String would remain empty.
		if (type.isEmpty()) {
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
		int answer = (int) (Math.random() * 101);

		System.out.println("開始猜數字吧！(0~100)。不想猜了就輸入-1可離開。");
		int guess = sc.nextInt();
		while (true) {
			if (guess == -1) {
				break;
			}
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
		System.out.println("阿文...請輸入樂透最高到幾號？(可輸入7~99)");
		int highest = sc.nextInt();
		System.out.println("阿文...請輸入你討厭哪個數字？(可輸入1~9)");
		int unwanted = sc.nextInt();

		int index = highest - (int) (highest / 10) + 1;
		if (unwanted <= (int) (highest / 10)) {
			index -= (highest % 10) + 1;
		}

		int[] choices = new int[index];
		index = 0;
		for (int i = 0; i <= highest / 10; i++) {
			int ones = 9;
			if (i == highest / 10) {
				ones = highest % 10;
			}
			for (int j = 0; j <= ones; j++) {
				if (i != unwanted && j != unwanted && (i != 0 || j != 0)) {
					choices[index] = i * 10 + j;
					index++;
				}
			}
		}
		for (index = 0; index < choices.length; index++) {
			if (choices[index] != 0) {
				System.out.print(choices[index] + "\t");
				if (index == 5 || (index + 1) % 6 == 0) {
					System.out.println();
				}
			} else {
				System.out.printf("總共有%d個數字可選\n", index);
				break;
			}
		}

		int[] randomIndices = new int[6];
		for (int i = 0; i < 6; i++) {
			randomIndices[i] = (int) (Math.random() * (index));
			for (int j = 0; j < i; j++) {
				while (randomIndices[i] == randomIndices[j]) {
					randomIndices[i] = (int) (Math.random() * (index));
					j = 0;
				}
			}
		}

		System.out.println("幫你隨機選6個 ^_^");
		Arrays.sort(randomIndices);
		for (int randomIndex : randomIndices) {
			System.out.print(choices[randomIndex] + "\t");
		}

	}

}
