package yyy;

public class CubeTest {
	public static void main(String[] args) {
		try {
			Cube c1 = new Cube(-5);
			System.out.println(c1.getVolume());
		} catch (CubeException ce) {
			System.out.println(ce);
		}
	}
}
