package mysql.sec02_kcity;

public class Main {
    public static void main(String[] args) {
        CityDao cityDao = new CityDao();
        City city = cityDao.getCityByID(2340);
        System.out.println(city);

        city = cityDao.getCityByName("수원");
        System.out.println(city);
    }
}
