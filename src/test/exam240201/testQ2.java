package test.exam240201;

import java.util.ArrayList;
import java.util.List;

public class testQ2 {
    public static void main(String[] args) {
        List<Member> tList;
        tList = getMemberList();
        for(Member m: tList){
            String tempTel = m.getTel();
            m.setTel("010-2244-5566");
            System.out.println(m);
            System.out.printf("변경 전: %s, 변경 후: %s%n", tempTel, m.getTel());
        }

    }

    static List<Member> getMemberList(){
        List<Member> list = new ArrayList<>();
        list.add(new Member(1, "james", 1995, "010-1234-4567"));
        list.add(new Member(2, "maria", 2000, "010-4567-1234"));

        return list;
    }
}
