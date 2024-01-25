package ch17_collection.part1_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Ex11_Sort {

    public static void main(String[] args) {
        List<Integer> scoreList = new ArrayList<>();
        scoreList.add(85); scoreList.add(78); scoreList.add(92); scoreList.add(88);

        // 오름차순 정렬
        scoreList.sort(Comparator.naturalOrder());
        System.out.println(scoreList);

        // 내림차순 정렬
        scoreList.sort(Comparator.reverseOrder());
        System.out.println(scoreList);

        List<String> fruits = new ArrayList<>();
        fruits.add("밤"); fruits.add("감"); fruits.add("사과"); fruits.add("배");
        fruits.sort(Comparator.naturalOrder());
        System.out.println(fruits);
    }
}
