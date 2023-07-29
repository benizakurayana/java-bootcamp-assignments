package homework.hw8;

import java.util.Objects;

public class Train implements Comparable<Train>{
	private int number;
	private String type;
	private String start;
	private String dest;
	private double price;
	
	public Train(int number, String type, String start, String dest, double price) {
		this.number = number;
		this.type = type;
		this.start = start;
		this.dest = dest;
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		/**
		 * According to the coding principle of Taiwan Railways, the train numbers already contain
		 * train type, departure and destination information. Therefore, I think it would be proper 
		 * to generate hash by the number variable.
		 */
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		return number == other.number;
	}

	@Override
	public int compareTo(Train o) {
//		if (this.number > o.number) {
//			return 1;
//		} else if (this.number < o.number) {
//			return -1;
//		}
//		return 0;
		return this.number - o.number;
	}

	// Getters
	public int getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public String getStart() {
		return start;
	}

	public String getDest() {
		return dest;
	}

	public double getPrice() {
		return price;
	}
}
