package xxx;

public class TestNineNine {
	public static void main(String[] args) {
		// 一：使用for迴圈 + while迴圈
		System.out.println("一：使用for迴圈 + while迴圈");
		for (int i = 1; i < 10; i++) {
			int j = 1;
			while (j < 10) {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
				j++;
			}
			System.out.println();
		}
		System.out.println("二：使用for迴圈 + do while迴圈");
		// 二：使用for迴圈 + do while迴圈
		for (int i = 1; i < 10; i++) {
			int j = 1;
			do {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
				j++;
			} while (j < 10);
			System.out.println();
		} 
		
		// 三：使用while迴圈 + do while迴圈
		System.out.println("三：使用while迴圈 + do while迴圈");
		int i = 1;
		int j = 1;
		while (i < 10) {
			j = 1;
			do {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
				j++;
			} while (j < 10);
			System.out.println();
			i++;
		}

	}
}
