package task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	private static final int NUMBER = 1000000;
	static List<String> list = new ArrayList<>();
	static String arr[] = { "static", "mama", "papa", "cosmos", "space", "shuttle",
			"cream", "clavicle" };

	static void removeDup() {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.contains(list.get(i))) {
				for (int j = list.size() - 1; j > i; j--) {
					if (list.get(j).equals(list.get(i))) {
						list.remove(j);
					}
				}
			}
		}
	}

	static void fillList(List<String> list) {
		Random r = new Random();
		for (int i = 0; i < NUMBER; i++) {
//			list.add(arr[Math.abs(r.nextInt()) % arr.length]);
			list.add(String.valueOf(r.nextInt(NUMBER/10)));
		}
	}

	static List<String> removeDup2(List<String> list) {
		List<String> mylist = new ArrayList<>();

		for (String string : list) {
			if (mylist.contains(string)) {
				continue;
			}

			mylist.add(string);
		}

		return mylist;
	}

	public static void main(String[] args) {
		list.add("kokokoko");
		list.add("kolokol");
		list.add("moloko");
		list.add("kokokoko");
		list.add("kokokoko");
		list.add("moloko");
		
		fillList(list);
		
		long timeout = System.currentTimeMillis();
		Set<String> set = new TreeSet<>(list);
		System.out.println(System.currentTimeMillis() - timeout);
		
		List<String> l;
		
//		removeDup();
//		System.out.println(System.currentTimeMillis() - timeout);
		
		timeout = System.currentTimeMillis();
		l = removeDup2(list);
		System.out.println(System.currentTimeMillis() - timeout);

	}
}
