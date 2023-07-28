package yyy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetLottery {
	public static void main(String[] args) {
		Set set = new HashSet();

		while (set.size() < 6) {
			int rand = (int) (Math.random() * 49) + 1;
			set.add(rand);
		}

		System.out.println(set);

		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
