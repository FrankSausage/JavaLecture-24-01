package ch17_collection.part2_set.sec12_member;

import java.util.Set;
import java.util.TreeSet;

public class MemberTreeSetMain {

    public static void main(String[] args) {
        Set<Member> set = new TreeSet<>();
        set.add(new Member(21, "james"));
        set.add(new Member(20, "maria"));
        set.add(new Member(51, "james"));
        set.add(new Member(20, "maria"));

        System.out.println(set);
    }
}
