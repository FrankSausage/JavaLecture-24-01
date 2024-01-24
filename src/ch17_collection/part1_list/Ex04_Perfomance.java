package ch17_collection.part1_list;

import java.util.*;

public class Ex04_Perfomance {

	public static void main(String[] args) {
		List<String> al = new ArrayList<>();
		List<String> ll = new LinkedList<String>();
		
		// ArrayList 맨 앞에 100000회 삽입하는 경우: 663 ms
		long startTime = System.nanoTime();
		for (int i = 1; i <= 100000; i++) {
			al.add(0, String.valueOf(i));
		}
		long endTime = System.nanoTime();
		System.out.println("ArrayList 소요시간: " + (endTime - startTime) + " ns");

		// LinkedList 맨 앞에 100000회 삽입하는 경우: 7 ms
		startTime = System.nanoTime();
		for (int i = 1; i <= 100000; i++) {
			ll.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 소요시간: " + (endTime - startTime) + " ns");
		System.out.println("==========================================================");

		// ArrayList 맨 뒤에 100000회 삽입하는 경우: 21 ms
		startTime = System.nanoTime();
		for (int i = 1; i <= 100000; i++) {
			al.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 소요시간: " + (endTime - startTime) + " ns");
		
		// LinkedList 맨 뒤에 100000회 삽입하는 경우: 4 ms
		startTime = System.nanoTime();
		for (int i = 1; i <= 100000; i++) {
			ll.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 소요시간: " + (endTime - startTime) + " ns");
	}

}
