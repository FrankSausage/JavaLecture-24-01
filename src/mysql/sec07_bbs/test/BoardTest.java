package mysql.sec07_bbs.test;

import mysql.sec07_bbs.dao.BoardDao;
import mysql.sec07_bbs.entity.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardTest {
    public static void main(String[] args) {
        BoardDao bDao = new BoardDao();

        String seesionUid = "james";    // james 가 로그인 한 것으로 가정
        int bid = 8;

        Board b = bDao.getBoard(bid);
        if(!b.getUid().equals(seesionUid)) {        //제임스가 작성한 글이 아니면 = 본인의 글이 아니면
            bDao.increaseCount("view", bid);
        }
        System.out.println(b);
        System.out.println("=============================================");

//        b = new Board("제목 7", "본문 7", "james");
//        bDao.insertBoard(b);
//        b = new Board("제목 8", "본문 8", "james");
//        bDao.insertBoard(b);
//        b = new Board("제목 9", "본문 9", "maria");
//        bDao.insertBoard(b);
//        b = new Board("제목 10", "본문 10", "sarah");
//        bDao.insertBoard(b);
//        b = new Board("제목 11", "본문 11", "brian");
//        bDao.insertBoard(b);

        List<Board> list;
        list = bDao.getBoardList("title","%",10,0);
        list.forEach(x -> System.out.println(x.listForm()));
        System.out.println("=============================================");
//        list = bDao.getBoardList("b.uid","james",10,0);
//        list.forEach(x -> System.out.println(x.listForm()));
//        System.out.println("=============================================");
//        list = bDao.getBoardList("uname","마리아",10,0);
//        list.forEach(x -> System.out.println(x.listForm()));

        bDao.close();
    }
}
