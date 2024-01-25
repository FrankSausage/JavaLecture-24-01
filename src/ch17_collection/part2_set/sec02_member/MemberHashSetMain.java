package ch17_collection.part2_set.sec02_member;

import java.util.HashSet;
import java.util.Set;

public class MemberHashSetMain {

    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        Member m1 = new Member(21, "James");
        Member m2 = new Member(20, "maria");
        Member m3 = new Member(21, "james");
        set.add(m1);
        set.add(m2);
        set.add(m3);
        System.out.println(set);
        System.out.println(m1.hashCode() + ", " + m2.hashCode() + ", " + m3.hashCode());
    }
}
