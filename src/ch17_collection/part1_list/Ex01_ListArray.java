package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.List;

public class Ex01_ListArray {

	public static void main(String[] args) {
		String[] array = "가나다라마바사".split("");
		System.out.println(array);
		
		List<String> list = new ArrayList<>();
		list.add("가"); list.add("나"); list.add("다"); list.add("라"); list.add("마");
		list.add("바"); list.add("사"); 
		System.out.println(list);
		
		//삭제
		array[2] = null; array[5] = null;
		System.out.println(array);
		
		list.remove("다"); list.remove("사");
		System.out.println(list);
		
		// 삭제 후 크기 비교
		System.out.println(array.length + ", " + list.size());
		
		// 
		list.add("아"); list.add("자"); list.add("차");
		System.out.println(list);


	}

}
