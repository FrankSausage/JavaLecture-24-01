package ch17_collection.part1_list.sec05_member;

import java.util.*;

public class MemberMain {
    private static List<Member> list = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            int age = 20 + (int) (Math.random() * 20);
            list.add(new Member(age, "이름" + i, Math.random() > 0.5 ? "남" : "여"));
        }
        System.out.println("================30세 이상================");

        // 나이가 30세 이상인 멤버 리스트
        List<Member> mList = getMemberListAboveThirty();
        mList.forEach(x -> System.out.println(x));

        // 성별 멤버 리스트
        System.out.println("===================성별==================");
        List<Member> gList = getMemberListByGender("여");
        gList.forEach(x -> System.out.println(x));

        // 새로운 멤버 추가
        System.out.println("=================새 멤버=================");
        Member member = new Member(39, "제임스", "남");
        insertMember(member);
        list.forEach(x -> System.out.println(x));

        // 멤버 삭제
        System.out.println("=================멤버 삭제=================");
        deleteMember("제임스");
        list.forEach(System.out::println);

        // 여성 멤버의 나이를 -1
        System.out.println("=================여성 멤버 나이=================");
        for (Member m : list) {
            if (m.getGender().equals("여")) {
                updateMember(m);
            }
        }
        list.forEach(x -> System.out.println(x));
    }

    static List<Member> getMemberListAboveThirty() {
        List<Member> mList = new ArrayList<>();
        for (Member m : list) {
            if (m.getAge() >= 30) {
                mList.add(m);
            }
        }
        return mList;
    }

    static List<Member> getMemberListByGender(String gender) {
        List<Member> gList = new ArrayList<Member>();
        for (Member m : list) {
            if (m.getGender().equals(gender)) {
                gList.add(m);
            }
        }
        return gList;
    }

    static void insertMember(Member member) {
        list.add(member);
    }

    static void deleteMember(String name) {
        Member member = null;
        for (Member m : list) {
            if (m.getName().equals(name)) {
                member = m;
                break;
            }
        }
        list.remove(member);
    }

    static void updateMember(Member member) {
        int index = list.indexOf(member);
        if (index >= 0) {
            member.setAge((member.getAge()) - 1);
            list.set(index, member);
        }
    }
}
