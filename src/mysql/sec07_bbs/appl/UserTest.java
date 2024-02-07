package mysql.sec07_bbs.appl;

import mysql.sec07_bbs.dao.UserDao;
import mysql.sec07_bbs.entity.User;

public class UserTest {
    public static void main(String[] args) {
        UserDao uDao = new UserDao();
        uDao.insertUser(new User("jaemin", "1234", "재민","james@gmail.com"));
    }
}
