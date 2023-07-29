package homework.hw8;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class TrainTest {
	public static void main(String[] args) {
		TrainTest tt = new TrainTest();
		
		ArrayList<Train> trains = new ArrayList<Train>(7);
		trains.add(new Train(202, "普悠瑪", "樹林", "花蓮", 400));
		trains.add(new Train(1254, "區間", "屏東", "基隆", 700));
		trains.add(new Train(118, "自強", "高雄", "台北", 500));
		trains.add(new Train(1288, "區間", "新竹", "基隆", 400));
		trains.add(new Train(122, "自強", "台中", "花蓮", 600));
		trains.add(new Train(1222, "區間", "樹林", "七堵", 300));
		trains.add(new Train(1254, "區間", "屏東", "基隆", 700));  // Intentionally duplicated object.
		
		// Q1
		tt.printUnique(trains);
		// Q2
		tt.printSorted(trains);
		// Q3
		tt.printSortedUnique(trains);
	}
	
	// Q1
	public void printUnique(Collection<Train> trains) {
		/**
		 * Takes a collection of Train objects and prints the information of the unique trains.
		 * The uniqueness is determined by the number variable of Train object.		 *
		 * @param trains A collection of Train objects.
		 */
		HashSet<Train> hs = new HashSet<Train>();
		for (Train t : trains) {
			hs.add(t);
		}
		System.out.println("----------Unique----------");
		for (Train t : hs) {
			System.out.printf("%d\t %s\t %s\t %s\t %.0f\n", 
					t.getNumber(), t.getType(), t.getStart(), t.getDest(), t.getPrice());
		}
	}
	
	// Q2
	public void printSorted(ArrayList<Train> trains) {
		/**
		 * Takes a collection of Train objects and prints the information of trains,
		 * sorting by the number variable of Train object in descending order.
		 * It's notable that this method doesn't filter out the duplicated trains.
		 * @param trains An ArrayList of Train objects.
		 */
		Collections.sort(trains);  // Sort by number in ascending order as defined in compareTo() of Train class.
		Collections.reverse(trains); // In descending order.
		System.out.println("----------Sorted by train number desc.----------");
		for (Train t : trains) {
			System.out.printf("%d\t %s\t %s\t %s\t %.0f\n", 
					t.getNumber(), t.getType(), t.getStart(), t.getDest(), t.getPrice());
		}
	}
	
	// Q3
	public void printSortedUnique(Collection<Train> trains) {
		/**
		 * Takes a collection of Train objects and prints the information of the unique trains,
		 * sorting by the number variable of Train object in descending order.
		 * The uniqueness is determined by the number variable of Train object.
		 * As my extended practice, this method then does the above again, 
		 * however, sorting by the price variable of Train object in ascending order.
		 * @param trains A collection of Train objects.
		 */
		Comparator<Train> mc = new MyCompare();
		TreeSet<Train> ts = new TreeSet<Train>(mc);
		
		for (Train t : trains) {
			ts.add(t);
		}
		System.out.println("----------Sorted by train number desc., unique----------");
		for (Train t : ts) {
			System.out.printf("%d\t %s\t %s\t %s\t %.0f\n", 
					t.getNumber(), t.getType(), t.getStart(), t.getDest(), t.getPrice());
		}
		
		// My extension to practice defining Comparator classes.
		Comparator<Train> mc2 = new MyCompareByPrice();
		TreeSet<Train> ts2 = new TreeSet<Train>(mc2);
		
		for (Train t : trains) {
			ts2.add(t);
		}
		System.out.println("----------Sorted by price asc., unique----------");
		for (Train t : ts2) {
			System.out.printf("%d\t %s\t %s\t %s\t %.0f\n", 
					t.getNumber(), t.getType(), t.getStart(), t.getDest(), t.getPrice());
		}
	}
	
	// Customized comparator for Q3
	class MyCompare implements Comparator<Train> {
		/**
		 * Sorts Train object by number in descending order.
		 */
		@Override
		public int compare(Train o1, Train o2) {
			return o1.compareTo(o2) * -1;
		}
	}

	class MyCompareByPrice implements Comparator<Train> {
		/**
		 * Sorts Train object by price in ascending order.
		 */
		@Override
		public int compare(Train o1, Train o2) {
			return (int) (o1.getPrice() - o2.getPrice());
		}
	}
}
