package mysql.sec06_user;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceMySQLImpl();
        User user = null;

//        user = new User("james", "1234", "제임스", "james@gmail.com");
//        userService.registerUser(user);
//
//        user = new User("maria", "1234", "마리아", "maria@naver.com");
//        userService.registerUser(user);
//
//        user = new User("brian", "1234", "브라이언", "brian@gmail.com");
//        userService.registerUser(user);
//
//        user = new User("sarah", "1234", "사라", "sarah@naver.com");
//        userService.registerUser(user);

//        user = userService.getUserByUid("admin");
//        System.out.println(user);
//
//        user = userService.getUserByUid("jaemin");
//        System.out.println(user);

//        System.out.println(userService.login("admin", "1234"));
//        System.out.println(userService.login("admin", "asdf"));
//        System.out.println(userService.login("jaemin", "1234"));

        List<User> list = userService.getUserList(2);
        list.forEach(System.out::println);

        userService.close();
    }
}
