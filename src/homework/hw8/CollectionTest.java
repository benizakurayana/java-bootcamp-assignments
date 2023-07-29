package homework.hw8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class CollectionTest {
	public static void main(String[] args) {
		/**
		 * Creates a Collection object and adds different types of data, including Number, BigInteger, 
		 * String and Object. This program then prints all the elements in the Collection object 
		 * using three different methods: Iterator, for loop, and for-each loop. 
		 * It then removes all elements that are not related to java.lang.Number, and then prints 
		 * all the remaining elements to check if the removal was successful.
		 */
		Collection<Object> list = new ArrayList<Object>();
		list.add(100);
		list.add(3.14);
		list.add(21L);
		list.add((short) 100);
		list.add(5.1);
		list.add("Kitty");
		list.add(100);
		list.add(new Object());
		list.add("Snoopy");
		list.add(BigInteger.valueOf(1000));
		
		// Iterator print.
		System.out.println("----------Iterator----------");
		Iterator<Object> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		// For loop print.
		System.out.println("----------For loop----------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(((ArrayList<Object>) list).get(i)); // Since list is declared as a Collection, to use get() method
														   // of ArrayList, type casting is needed.
		}
		
		// For each print.
		System.out.println("----------For each----------");
		for (Object ele : list) {
			System.out.println(ele);
		}
		
		// Remove elements that don't belong to java.lang.Number.
		Iterator<Object> it2 = list.iterator();
		while (it2.hasNext()) {
			if (!(it2.next() instanceof Number)) {
				it2.remove(); // Have to use remove() method of Iterator. If the remove() of Collection is used here,
							  // there will be ConcurrentModificationException, which is caused by altering the collection
							  // during an iteration.
			}
		}
		
		// Print the remaining elements.
		System.out.println("After removing elements that don't belong to java.lang.Number");
		Iterator<Object> it3 = list.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
	}
}
