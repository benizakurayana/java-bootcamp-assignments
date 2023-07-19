package homework.hw5;

// Q4
public class MyRectangleMain {
	public static void main(String[] args) {
		MyRectangle rect1 = new MyRectangle();
		rect1.setWidth(10);
		rect1.setDepth(20);
		System.out.println(rect1.getArea());
		
		MyRectangle rect2 = new MyRectangle(10, 20);
		System.out.println(rect2.getArea());
	}
}
