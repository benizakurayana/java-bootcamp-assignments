package homework;

public class Homework1 {
	public static void main(String[] args) {
		// Q1
		int a = 12, b = 6;
		int sum = a + b;
		int product = a * b;
		System.out.printf("12與6的和為%d%n", sum);
		System.out.printf("12與6的積為%d%n", product);

		// Q2
		int egg = 200;
		int dozen = (int)(egg / 12);
		int remainder = egg % 12;
		System.out.printf("%d顆蛋共是%d打%d顆%n", egg, dozen, remainder);

		// Q3
		final int DAY = 60*60*24;
		final int HOUR = 60*60;
		final int MINUTE = 60;
		int questionSec = 256559;
		int day = (int)(questionSec / DAY);
		int hour = (int)((questionSec % DAY) / HOUR);
		int minute = (int)(((questionSec % DAY) % HOUR) / MINUTE);
		int second = (int) (((questionSec % DAY) % HOUR) % MINUTE);
		System.out.printf("%d秒是%d天%d小時%d分%d秒%n", questionSec, day, hour, minute, second);
		
		// Q4
		final double PI = 3.1415;
		int radius = 5;
		double area = radius * radius * PI;
		double circum = radius * 2 * PI;
		System.out.printf("半徑為%d的圓，面積為%f，圓周長為%f%n", radius, area, circum);

		// Q5 複利公式FV = PV*(1+R)^n
		double rate = 0.02;
		int presentValue = 1500000;
		int year = 10;
		double futureValue = presentValue * Math.pow((1 + rate), year);
		System.out.printf("某人在銀行存入150萬，銀行利率為2%%，如果每年利息都繼續存入銀行，10年後本金加利息共有%.0f元%n", futureValue);

		// Q6
		System.out.println(5 + 5);  // 印出10，兩個整數相加結果為整數
		System.out.println(5 + '5');  // 印出58，字元'5'與整數相加，晉升成int，字元'5'轉換成int為53
		System.out.println(5 + "5");  // 印出55，字串"5"遇到+號，進行concatenation，將整數5加到字串中
		// 字元'5'驗證
		System.out.println((int)'5'); // '5'轉換為十進位為53 
		System.out.println('\u0035'); // '5'的Unicode編碼為0035，轉換成十進位16*3+5=53

	}
}
