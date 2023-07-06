package homework;

public class Homework2 {
	public static void main(String[] args) {
		Homework2 hw2 = new Homework2();
		
		hw2.evenNumSum(1, 1000);
		hw2.multiplyByFor(1, 10);
		hw2.multiplyByWhile(1, 10);
		hw2.squareNums(1, 10);
		hw2.withoutFour(49);
		hw2.numTriangle(10);
		hw2.letterTriangle(6);
	}

	// Q1
	public void evenNumSum(int low, int high) {
		int sum = 0;
		for (;low <= high; low++) {
			if (high % 2 == 1) {
				continue;
			}
			sum += low;
		}
		System.out.println(sum);
	}
	
	// Q2
	public void multiplyByFor(int low, int high) {
		int product = 1;
		for (;low <= high; low++) {
			product *= low;
		}
		System.out.println(product);
	}
	
	// Q3
	public void multiplyByWhile(int low, int high) {
		int product = 1;
		while (low <= high) {
			product *= low;
			low++;
		}
		System.out.println(product);
	}
	
	// Q4
	public void squareNums(int low, int high) {
		for (; low <= high; low++) {
			System.out.print(low * low + " ");
		}
		System.out.println();
	}
	
	// Q5
	public void withoutFour(int highest) {
		int choice = 0;
		for (int i = 0; i < highest / 10; i++) {
			for (int j = 0; j <= 9; j++) {
				if (i == 4 || j == 4 || i == 0 && j == 0) {
					continue;
				} else {
					int num = i * 10 + j;
						choice += 1;
						System.out.print(num + " ");
				}	
			}
		}
		System.out.println(" " + "共" + choice +"個數字" );
	}
	
	// Q6
	public void numTriangle(int layer) {
		for (; layer > 0; layer--) {
			for (int i = 1; i <= layer; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	// Q7
	public void letterTriangle(int layer) {
		char letter = 'A';
		letter -= 1;
		for (int i = 0; i < layer; i++) {
			letter += 1;
			for(int j = 0; j < i + 1; j++) {
				System.out.print(letter + " ");
			}
			System.out.println();	
		}
	}
	
}
