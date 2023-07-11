package homework;

import java.util.Scanner;
import java.util.Arrays;

public class Homework3 {
	static Scanner sc = new Scanner(System.in); // Suggested by Vic(耀升學長) to prevent the error of closing scanners.

	public static void main(String[] args) {
		Homework3 hw3 = new Homework3();

		hw3.distinguishTriangle();
		hw3.guessNumber();
		hw3.lotteryPickNum();
		sc.close();
	}

	// Q1
	public void distinguishTriangle() {
		/*
		 * This method checks if the three integers input by user can form a triangle,
		 * distinguishes the type of triangle and whether it's a right triangle, by
		 * comparing the three integers.
		 * It's notable that an equilateral(正三角形) triangle is theoretically also a special
		 * case of an isosceles(等腰三角形) one. 
		 * This method determines it as an equilateral one.
		 */
		int[] triangle = new int[3];
		String type = "";
		boolean vertical = false;

		System.out.println("請輸入三個整數：");
		for (int i = 0; i < 3; i++) {
			triangle[i] = sc.nextInt();
		}

		int a = 0, b = 0, c = 0;
		for (int i = 0; i < 3; i++) {
			// Use modulo to ensure each element in the array is compared with all the others.
			a = triangle[i % 3];
			b = triangle[(i + 1) % 3];
			c = triangle[(i + 2) % 3];

			// Check triangle type: not a triangle, equilateral(正三角形) or isosceles(等腰三角形)
			if (a == 0 || a + b <= c || Math.abs(a - b) >= c) {
				type = "不是";
				break;
			} else if (a == b) {
				// Determine equilateral or isosceles.
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
		// If none of the three triangle type conditions above is fulfilled, the type String would remain empty.
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
		/*
		 * This method generates a random number between 0 and 100, as the answer,
		 * and keeps prompting user to enter a guessed number until the correct number is guessed. 
		 * This method shows whether the guessed number is lower or higher than the answer.
		 */
		int answer = (int) (Math.random() * 101);

		System.out.println("開始猜數字吧！(0~100)。不想猜了就輸入-1可離開。");
		int guess = sc.nextInt();
		while (true) {
			if (guess == -1) {  // Exit: just a shortcut when I'm tired of testing the codes! :)
				break;
			}
			else if (guess == answer) {
				System.out.println("猜對了，答案是" + answer);
				break;  // Exit: normally when the correct number is guessed. 
			}
			else if (guess > 100 || guess < 0) {
				System.out.println("請輸入0~100的數字");
			}
			else if (guess > answer) {
				System.out.println("猜錯囉．你猜的數字比答案大");
			} else {
				System.out.println("猜錯囉．你猜的數字比答案小");
			}
			guess = sc.nextInt();
		}

	}

	// Q3
	public void lotteryPickNum() {
		/*
		 * This method generates a list of suggested six lottery numbers based on two user inputs: 
         *  - The highest number for the lottery (between 7 and 99) 
         *  - User's unwanted digit (between 1 and 9) 
         * The remaining numbers are the result of filtering out the numbers containing the unwanted digit.
         * This method calculates the number of remaining numbers, prints them,
         * and further randomly selects and prints six numbers from them.
		 */
		
		/* The algorithm used in this method is as follows:
		 * 1. From 1 to 99
		 * We can generate numbers from 1 to 99 by a double nested for loop.
		 * Each number can be calculated as: i * 10 + j
		 * It's notable that as we loop to the highest number, its j shall be: highest % 10
		 * The following is an example:
		 * Highest: 36 
		 *    j-----------------------------------j
		 * i (0)  1   2   3   4   5   6   7   8   9
		 * | 10  11  12  13  14  15  16  17  18  19
		 * | 20  21  22  23  24  25  26  27  28  29
		 * i 30  31  32  33  34  35  36             <-- last row, 36 = 3*10 + 36%10
		 * 
		 * 2. Unwanted digit
		 * We can filter out the unwanted digit by setting conditions to i and j.
		 * To reduce space complexity, we shall declare an array with the length as exactly the number of remaining numbers.
		 * The number of remaining numbers can be calculated as following pseudocode:
		 * Ones digit of highest = highest % 10  (highest的個位數)
		 * Tens digit of highest = (int) (highest / 10)  (highest的十位數)
		 * if (unwanted < tens) 
		 *     remainingNum = highest - (tens + 10)
		 * if (unwanted == tens) 
		 *	   remainingNum = highest - (tens + ones + 1)
		 * if (unwanted > tens) 
		 *     if (unwanted > ones)
		 *	       remainingNum = highest - tens
		 *	   if (unwanted <= ones)
		 *	       remainingNum = highest - (tens + 1)
		 */
		System.out.println("阿文...請輸入樂透最高到幾號？(可輸入7~99)");
		int highest = sc.nextInt();
		System.out.println("阿文...請輸入你討厭哪個數字？(可輸入1~9)");
		int unwanted = sc.nextInt();

		// Calculate the number of remaining numbers.
		int ones = highest % 10;  //個位數
		int tens = (int) (highest / 10);  //十位數
		int remainingNum = highest;

		if (unwanted < tens) {
			remainingNum -= (tens + 10);
		} else if (unwanted == tens) {
			remainingNum -= (tens + ones + 1);
		} else {
			if (unwanted > ones) {
				remainingNum -= tens;
			} else {
				remainingNum -= (tens + 1);
			}
		}
		
		// Put numbers left in the choices array.
		int[] choices = new int[remainingNum];
		int index = 0;
		for (int i = 0; i <= (int) (highest / 10); i++) {
			int lastRowOnes = 9;
			if (i == (int) (highest / 10)) {  // Last row.
				lastRowOnes = highest % 10;
			}
			for (int j = 0; j <= lastRowOnes; j++) {
				if (i != unwanted && j != unwanted && (i != 0 || j != 0)) {
					choices[index] = i * 10 + j;
					index++;  // index equals to length of array at the end of loop.
				}
			}
		}
		
		for (index = 0; index < choices.length; index++) {
			System.out.print(choices[index] + "\t");
			if (index == 5 || (index + 1) % 6 == 0) {
				System.out.println();  // Print six numbers in each row.
			}
		}
		System.out.printf("總共有%d個數字可選\n", index);
		
		// Generate six random numbers as the indices for the choices array.
		int[] randomIndices = new int[6];
		for (int i = 0; i < 6; i++) {
			randomIndices[i] = (int) (Math.random() * (index));
			
			// To ensure the newly generated random number is not duplicated with previous ones.
			for (int j = 0; j < i; j++) {
				while (randomIndices[i] == randomIndices[j]) {
					randomIndices[i] = (int) (Math.random() * (index));
					j = 0;
				}
			}
		}
		Arrays.sort(randomIndices);  // Ascending order.
		
		System.out.println("幫你隨機選6個 ^_^");
		for (int randomIndex : randomIndices) {
			System.out.print(choices[randomIndex] + "\t");
		}

	}

}
