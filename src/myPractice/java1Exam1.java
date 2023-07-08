package myPractice;

import java.util.Iterator;

public class java1Exam1 {
	public static void main(String[] args) {
		// Q17	
		int binary = 0b1111;
		int octal = 017;
		int hexadecimal = 0xF;
		if (binary == octal && octal == hexadecimal && hexadecimal == binary) {
			System.out.println("15");
		}
		
		// Q7
		int i1 = 011;
		int i2 = 9;
		System.out.println(i2-i1);
		
		// Q24
		int valid = 0;
		if (valid) {
		    System.out.println("valid");
		} else {
		    System.out.println("not valid");
		}
		
		// Q19
		int sum = 0, number = 3;

		if (number % 2 == 0) {
		    System.out.println(sum++);
		    break;
		} else {
		    for (int i = 0; i < number; i++) {
		        sum += i;
		    }
		    System.out.println(sum);
		}
		
	}
}
