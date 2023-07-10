package xxx;

public class TestRandomArray {
	public int[][] getRandomArray() {
		int[][] arr = new int[3][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (int)(Math.random() * 31);
			}
		}
		return arr;
	}
	
	public int[][] arraySum(int[][] arr1, int[][] arr2) {
		int[][] arrSum = new int[3][3];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				arrSum[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return arrSum;
	}
	
	public void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		TestRandomArray tra = new TestRandomArray();
		int[][] x = tra.getRandomArray();
		int[][] y = tra.getRandomArray();
		int[][] z = tra.arraySum(x, y);
		tra.printArray(x);
		tra.printArray(y);
		tra.printArray(z);
		
	}
}
