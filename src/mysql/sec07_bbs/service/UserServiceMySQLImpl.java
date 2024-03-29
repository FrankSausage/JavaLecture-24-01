package mysql.sec07_bbs.service;

import mysql.sec07_bbs.dao.UserDao;
import mysql.sec07_bbs.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserServiceMySQLImpl implements UserService {
    UserDao userDao = new UserDao();

    @Override
    public User getUserByUid(String uid) {
        User user = userDao.getUserByUid(uid);
        return user;
    }

    @Override
    public List<User> getUserList(int page) {
        int offset = (page - 1) * COUNT_PER_PAGE;
        List<User> uList = userDao.getUserList(COUNT_PER_PAGE, offset);
        return uList;
    }

    @Override
    public void registerUser(User user) {   // user 는 아직 암호화된 패스워드가 없다고 가정
        User u = userDao.getUserByUid(user.getUid());
        if(u != null){      // 중복 체크
            return;
        }
        String hashedPwd = BCrypt.hashpw(user.getPwd(), BCrypt.gensalt());
        user.setPwd(hashedPwd);
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String uid) {
        userDao.deleteUser(uid);
    }

    @Override
    public int login(String uid, String pwd) {
        User user = userDao.getUserByUid(uid);
        if(user == null){
            return USER_NOT_EXIST;
        }
        if(BCrypt.checkpw(pwd, user.getPwd())){
            return CORRECT_LOGIN;
        }
        return WRONG_PASSWORD;
    }

    @Override
    public void close() {
        userDao.close();
    }
}
