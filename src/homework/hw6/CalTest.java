package homework.hw6;

import java.util.Scanner;
import java.util.InputMismatchException;

public class CalTest {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		Scanner sc = new Scanner(System.in);

		while (true) {
			
			try {
				System.out.println("請輸入x的值：(輸入q以離開本程式)");
				String firstInput = sc.next();
				if (firstInput.equals("q")) {
					System.out.println("再見！");
					break;
				}
				int x = Integer.parseInt(firstInput); // if firstInput is not an integer, 
													  // this method will throw a NumberFormatException.
				
				System.out.println("請輸入y的值：");
				int y = sc.nextInt();
				if (y < 0) {
					System.out.println("次方為負值，結果回傳不為整數！");
				}

				int p = cal.powerXY(x, y);
				System.out.printf("%d的%d次方等於%d\n", x, y, p);
			} catch (InputMismatchException e) {
				System.out.println("輸入格式不正確");
				sc.next();  //Skip the incorrect input.
			} catch (NumberFormatException e) {
				System.out.println("輸入格式不正確");
				//sc.next();  //Skip the incorrect input.
			}
			catch (CalException e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();  // Close the scanner before this program ends.
	}
}
