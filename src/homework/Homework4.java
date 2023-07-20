package homework;

import java.util.Arrays;
import java.util.Scanner;

public class Homework4 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Homework4 hw4 = new Homework4();
		// Q1
		double[] numbers = { 29, 100, 39, 41, 50, 8, 66, 77, 95, 15 }; 
		hw4.avgAndAbove(numbers);
		// Q2
		String s = "Hello World";
		System.out.println(hw4.reverseString(s));
		// Q3
		String[] planets = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };
		hw4.findVowels(planets);
		// Q4
		hw4.borrowMoney();
		// Q5
		hw4.countDayOfTheYear();
		// Q6
		hw4.countTimesOfBest();
		
	}
	
	// Helper method
	public void printArray(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
	}
	
	// Helper method
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
	}
	
	// Helper method
	public void printArray(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
	}
	
	// Helper method
	public int arraySum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	// Q1
	public void avgAndAbove(double[] numbers) {
		/**
		 * Calculates and prints the average of the elements from the specified array.
		 * This method also finds and prints the elements that are larger than the
		 * average. If all elements are equal, the average will be printed along with a
		 * message saying that all elements are equal.
		 *
		 * @param numbers the specified array of doubles Declared as an array of
		 *                doubles, so that it can take in floating-point numbers, for
		 *                more generalized usages.
		 */
		double sum = 0;
		boolean allSame = false;
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			// Check if all elements are equal.
			if (i + 1 < numbers.length) {
				if (numbers[i] == numbers[i + 1]) {
					allSame = true;
				} else {
					allSame = false;
				}
			}
			sum += numbers[i];
		}

		double avg = sum / numbers.length;
		System.out.println("平均值：" + avg);

		if (allSame) {
			System.out.println("每個數字都一樣大(與平均值相等)");
		} else {
			for (int i = 0; i < numbers.length; i++) {
				// Since the array is sorted, when we iterate through the array and find the
				// first element that is larger than avg, it means all the remaining elements
				// are larger than avg.
				if (numbers[i] > avg) {
					System.out.print("大於平均值的數字：");
					// Print all the remaining elements.
					this.printArray(Arrays.copyOfRange(numbers, i, numbers.length));
					System.out.println();
					break;
				}
			}
		}
	}
	
	// Q2
	public String reverseString(String str) {
		/**
		 * Reverse a specified String.
		 * @param str the String to reverse.
		 * @return the reversed String.
		 */
		String strBackward = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			strBackward += str.substring(i, i + 1);
		}
		return strBackward;
	}
	
	// Q3
	public void findVowels(String[] words) {
		/**
		 * Finds out and print the total number of vowels letters in a specified array of Strings, 
		 * along with numbers of each vowel and consonants letters.
		 * @param words the specified array of Strings. 
		 */
		int[] numVowels = new int[6];
		
		for (String word : words) {
			char[] chars = word.toCharArray();  // Transform it to array of chars.
			for (char ch : chars) {  // So that we can iterate through all chars in it.
				switch (ch) {
				case 'a':
					numVowels[0] += 1;
					break;
				case 'e':
					numVowels[1] += 1;
					break;
				case 'i':
					numVowels[2] += 1;
					break;
				case 'o':
					numVowels[3] += 1;
					break;
				case 'u':
					numVowels[4] += 1;
					break;
				default:
					numVowels[5] += 1;
				}
			}
		}
		
		this.printArray(words);
		System.out.printf(" 母音共有%d個\n", this.arraySum(Arrays.copyOf(numVowels, 5)));
		System.out.printf("A: %d\tE: %d\tI: %d\tO: %d\tU: %d\t子音: %d\n", 
							numVowels[0], numVowels[1], numVowels[2], numVowels[3], numVowels[4], numVowels[5]);
	}
	
	// Q4
	public void borrowMoney() {
		/**
		 * Allows user to input the amount of money to borrow money from colleagues. 
		 * This method checks the available money at hand of each colleague, and finds those 
		 * who have enough money to lend. 
		 * And it prints the employee numbers of those who can lend the requested amount 
		 * and how many of them there are.
		 * If no one has enough money to lend, a message saying that is printed.
		 */
		int[][] colleaguesAndMoney = { { 25, 32, 8, 19, 27 }, 
				                       { 2500, 800, 500, 1000, 1200 } };
		int moneyEnough = 0;
		
		System.out.println("請輸入你要借多少錢:");
		int money = sc.nextInt();
		
		// We could have just declare an array with length of 5, which would be definitely enough.
		// But I guess it's not the best practice.
		// So I choose to find out the array size first.
		for (int i = 0; i < colleaguesAndMoney[1].length; i++) {
			if (money <= colleaguesAndMoney[1][i]) {
				moneyEnough += 1;
			}
		}
		
		int[] colleagueEnoughMoney = new int[moneyEnough];
		int j = 0;
		for (int i = 0; i < colleaguesAndMoney[1].length; i++) {
			if (money <= colleaguesAndMoney[1][i]) {
				colleagueEnoughMoney[j] = colleaguesAndMoney[0][i];
				j++;
			}
		}
		
		if (colleagueEnoughMoney.length == 0) {
			System.out.println("都沒有人可以借錢QQ");
		} else {
			System.out.print("有錢可借的員工編號：");
			this.printArray(colleagueEnoughMoney);
			System.out.printf(" 共%d人！\n", moneyEnough);
		}
	}
	
	// Q5
	public void countDayOfTheYear() {
		/**
		 * Calculates the day of the year based on the input date(YYYY MM DD).
		 * This method allows user to enter the date and performs input validation.
		 * It checks for leap years, small months(30 days), and the correct number of days for each month.
		 * After ensuring the input is valid, it calculates and prints the day of the year.
		 */
		int year = 0;
		int month = 0;
		int day = 0;
		System.out.println("請輸入年月日(YYYY MM DD 請以空格或enter鍵隔開)");

		boolean isLeapYear = false;
		boolean isSmallMonth = false;
		int[] month30days = { 4, 6, 9, 11 };  // 小月
		
		while (true) {
			year = sc.nextInt();
			month = sc.nextInt();
			day = sc.nextInt();

			boolean inputCorrect = true;
			if (year <= 0) {
				System.out.print("年份輸入錯誤！ ");
				inputCorrect = false;
			}

			if (month > 12 || month <= 0) {
				System.out.print("月份輸入錯誤！ ");
				inputCorrect = false;
			}

			// Check if it's leap year. (閏年)
			isLeapYear = false;
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				isLeapYear = true;
			}

			isSmallMonth = Arrays.binarySearch(month30days, month) >= 0;

			if (day > 31 || day <= 0) {
				System.out.print("日輸入錯誤！");
				inputCorrect = false;
			} else if (isSmallMonth && day == 31) {
				System.out.print("此月份只有30天！");
				inputCorrect = false;
			} else if (month == 2 && isLeapYear && day > 29) {
				System.out.print("此月份只有29天！");
				inputCorrect = false;
			} else if (month == 2 && !isLeapYear && day > 28) {
				System.out.print("此月份只有28天！");
				inputCorrect = false;
			}

			if (inputCorrect) {  // Passed all the validation checks above.
				break;
			} else {
				System.out.println("請重新輸入");
			}
		}

		int dayOfYear = 0;
		for (int i = 1; i < month; i++) {
			if (i == 2 && isLeapYear) {
				dayOfYear += 29;
			} else if (i == 2 && !isLeapYear) {
				dayOfYear += 28;
			} else if (Arrays.binarySearch(month30days, i) >= 0) {
				dayOfYear += 30;
			} else {
				dayOfYear += 31;
			}
		}
		dayOfYear += day;

		System.out.printf("輸入的日期為該年第%d天\n", dayOfYear);
	}
	
	// Q6
	public void countTimesOfBest() {
		/**
		 * Calculates the number of times each student got the highest score.
		 * This method takes a 2D array of scores, where each row represents a round of exam,
		 * and each column represents a student.
		 * It identifies the highest score for each student in each round and keeps track of the count.
		 * Finally, it prints the number of times each student achieved the highest score.
		 */
		int[][] scores = { { 10, 35, 40, 100, 90, 85, 75, 70 },
				           { 37, 75, 77, 89, 64, 75, 70, 95 },
				           { 100, 70, 79, 90, 75, 70 ,79 ,90 },
				           { 77, 95, 70, 89, 60 ,75, 85, 89 },
				           { 98, 70, 89, 90 ,75 ,90 ,89 ,90 },
				           { 90, 80, 100, 75, 50 ,20, 99 ,75 }};
		
		int[] timesOfBest = new int[8];
		
		for (int i = 0; i < scores.length; i++) {
			int max = 0;
			int bestThisRound = 0;
			for (int j = 0; j < scores[i].length; j++) {
				if (scores[i][j] > max) {
					max = scores[i][j];
					bestThisRound = j;  // Mark the student's index.
				}
			}
			timesOfBest[bestThisRound] += 1; // Keep track of the count.
		}
				
		for (int i = 0; i < scores[0].length; i++) {
			System.out.printf("%d號：%d次\t", i+1, timesOfBest[i]);
		}
	}
}
