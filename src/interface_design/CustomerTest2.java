package interface_design;

public class CustomerTest2 {
	
	public static void main(String[] args) {
		Computer2 c2 = new Computer2();
		Keyboard2 k1 = new Keyboard2();
		Mouse2 m1 = new Mouse2();
		
		c2.setUSB(k1);
		c2.workWithUSB();
		
		c2.setUSB(m1);
		c2.workWithUSB();
		
		Printer2 p2 = new Printer2();
		c2.setUSB(p2);
		c2.workWithUSB();
		
		
		c2.workWithUSB();
	}
}
