package homework;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.text.Format;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Homework10 {
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Homework10 hw10 = new Homework10();
		
		// Q1
		hw10.randomAndIsPrime();
		// Q2
		hw10.chooseNumFormat();
		// Q3
		hw10.chooseDateFormat();
		
		hw10.sc.close();
		}
	
	// Q1
	public void randomAndIsPrime() {
		/**
		 * Generates five random integers, determine if they are prime numbers and prints the results.
		 * This method uses the following logic to check if a number is a prime number:
		 * - If the number is 1, it is not a prime number.
		 * - If it is equal to 2 or 3, it is a prime number.
		 * - When the number is greater than 3, if it can be divided by integers less than or equal to 
		 *   the square root of itself, it is a not prime number.
		 */
		// Generate five random non-repeating integers between 1-100.
		Set<Integer> randomNums = new HashSet<>();
		while (randomNums.size() < 5) {
			randomNums.add((int) (Math.random() * 100 + 1));
		}
		
		// Determine whether each of the integers is a prime number.
		boolean isPrime = false;
		for (int num : randomNums) {
			if (num == 1) {
				isPrime = false;
			} else if (num == 2 || num == 3) {
				isPrime = true;
			}
			else {
				int squareRoot = (int) Math.sqrt(num);
				for (int factor = squareRoot; factor > 1; factor--) {
					if (num % factor == 0) {
						isPrime = false;
						break;
					}
					if (factor == 2) {
						isPrime = true;
					}
				}
			}
			
			// Print the result.
			if (isPrime) {
				System.out.println(num + " is a prime number");
			} else {
				System.out.println(num + " is not a prime number.");
			}
		}
		System.out.println();
	}
	
	// Q2
	public void chooseNumFormat() {
		/**
		 * Takes user input of a number and asks user to choose the desired format: 
		 * (1) for thousand separators 
		 * (2) for percentage
		 * (3) for scientific notation 
		 * This method then formats the number accordingly and prints the result by using DecimalFormat objects.
		 * It uses regular expressions to validate the user inputs of number and format option are entered correctly. 
		 */
		// Take number input.
		System.out.print("請輸入數字：");
		String s = sc.next();
		while (!s.matches("^[+-]?\\d+(\\.\\d+)?$")) {
			System.out.println("數字格式不正確，請再輸入一次！");
			System.out.print("請輸入數字：");
			s = sc.next();
		}
		double number = Double.parseDouble(s);
		
		// Take option input.
		System.out.print("欲格式化成(1)千分位(2)百分比(3)科學記號：");
		s = sc.next();
		while (!s.matches("^[1-3]$")) {
			System.out.println("選項格式不正確，請再輸入一次！");
			System.out.print("欲格式化成(1)千分位(2)百分比(3)科學記號：");
			s = sc.next();
		}
		int option = Integer.parseInt(s);
		
		// Print the result.
		switch (option) {
			case 1:
				Format df = new DecimalFormat("#,###");
				System.out.println("千分位數字：" + df.format(number));
				break;
			case 2:
				Format df2 = new DecimalFormat("0%");
				System.out.println("百分比數字：" + df2.format(number));
				break;
			case 3:
				Format df3 = new DecimalFormat("0.00E00");
				System.out.println("科學記號數字：" + df3.format(number));
		}
		
		System.out.println();
	}
	
	// Q3
	public void chooseDateFormat() {
		/**
		 * Takes user input of a date and asks user to choose the desired format: 
		 * (1) for year/month/day 
		 * (2) for month/day/year
		 * (3) for day/month/year 
		 * This method then formats the date accordingly and prints the result by using SimpleDateFormat objects.
		 * It uses regular expressions to validate the user inputs of date and format option are entered correctly.
		 */
		// Take date input.
		System.out.print("請輸入日期(年月日，例如20110131)：");
		String s = sc.next();
		Date date = null;
		while (true) {
			if (s.matches("^\\d{8}$")) {  // Check if input matches eight digits.
				String inputPattern = "yyyyMMdd";
				SimpleDateFormat df = new SimpleDateFormat(inputPattern);
				df.setLenient(false);  // Strict parsing: 20230631 will not be transformed into 20230701.
				
				try {
					date = df.parse(s);  // Check if input is a valid date.
					break;
				} catch (ParseException e) {
					System.out.println("此日期不存在，請再輸入一次！");
				}
			} else {
				System.out.println("日期格式不正確，請再輸入一次！");
			}
			System.out.print("請輸入日期(年月日，例如20110131)：");
			s = sc.next();
		}
		
		// Take option input.
		System.out.print("欲格式化成(1)年/月/日(2)月/日/年(3)日/月/年：");
		s = sc.next();
		while (!s.matches("^[1-3]$")) {
			System.out.println("選項格式不正確，請再輸入一次！");
			System.out.print("欲格式化成(1)年/月/日(2)月/日/年(3)日/月/年：");
			s = sc.next();
		}
		int option = Integer.parseInt(s);
		
		// Print the result.
		switch (option) {
		case 1:
			Format df = new SimpleDateFormat("yyyy/MM/dd");
			System.out.println("年/月/日：" + df.format(date));
			break;
		case 2:
			Format df2 = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("月/日/年：" + df2.format(date));
			break;
		case 3:
			Format df3 = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("日/月/年：" + df3.format(date));
		}
	}
}
