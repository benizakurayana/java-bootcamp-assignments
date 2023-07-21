package yyy;

public class Cube {
	private double length;
	
	public Cube() {
	}
	
	public Cube(double length) throws CubeException {
		setLength(length);
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) throws CubeException {
		if (length <= 0) {
			throw new CubeException("正立方體邊長不得為0或負數");
		}
		this.length = length;
	}
	
	public double getVolume() {
		return Math.pow(length, 3);
	}
	
}
