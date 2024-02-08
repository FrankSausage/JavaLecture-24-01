package mysql.sec07_bbs.test;

import mysql.sec07_bbs.dao.BoardDao;
import mysql.sec07_bbs.dao.ReplyDao;
import mysql.sec07_bbs.entity.Reply;

import java.util.ArrayList;
import java.util.List;

public class ReplyTest {

    public static void main(String[] args) {
        ReplyDao rDao = new ReplyDao();
        BoardDao bDao = new BoardDao();
        String seesionUid = "sarah";
        int bid = 8;

//        Reply r= new Reply();
//        r.setComment("댓글 3");
//        r.setUid(seesionUid);
//        r.setBid(bid);

//        rDao.insertReply(r);
//        bDao.increaseCount("reply", bid);

        List<Reply> list;
        list = rDao.getReplyList(bid);
        list.forEach(x -> System.out.println(x));


        bDao.close(); rDao.close();

    }
}
