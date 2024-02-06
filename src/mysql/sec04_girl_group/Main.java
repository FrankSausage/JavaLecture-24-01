package mysql.sec04_girl_group;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GirlGroupDao ggDao = new GirlGroupDao();

        GirlGroup gg = ggDao.getGirlGroupByGid(1012);
        System.out.println(gg);

        gg = ggDao.getGirlGroupByName("소녀");
        System.out.println(gg);
        System.out.println("=================================");

//       gg = new GirlGroup("NewJeans", LocalDate.parse("2022-07-22"), 121);
//       ggDao.insertGirlGroup(gg);

//        gg = ggDao.getGirlGroupByGid(1007);
//        gg.setName("에프엑스");
//        ggDao.updateGirlGroup(gg);

//        ggDao.deleteGirlGroup(1015);

        List<GirlGroup> ggList = ggDao.getGirlGroupByDebutList(2005, 2022);
        ggList.forEach(System.out::println);

        ggDao.close();
    }
}
