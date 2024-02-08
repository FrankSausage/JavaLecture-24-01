package mysql.sec07_bbs.service;

import mysql.sec07_bbs.dao.BoardDao;
import mysql.sec07_bbs.dao.ReplyDao;
import mysql.sec07_bbs.entity.Board;
import mysql.sec07_bbs.entity.Reply;

import java.util.List;

public class BoardServiceMySQLImpl implements BoardService {
    String sessionUid = "james";        // james로 로그인 하였다고 가정
    BoardDao bDao = new BoardDao();
    ReplyDao rDao = new ReplyDao();

    @Override
    public List<Board> getBoardList(int page, String field, String query) {
        int offset = (page - 1) * COUNT_PER_PAGE;
        if (field == null || field.isEmpty()) {
            field = "title";
            query = "%";
        }
        return bDao.getBoardList(field, query, COUNT_PER_PAGE, offset);
    }

    @Override
    public Board getBoard(int bid) {
        Board board = bDao.getBoard(bid);
        if(!board.getUid().equals(sessionUid)){
            bDao.increaseCount("view", bid);
        }
        List<Reply> list = rDao.getReplyList(bid);
        if(!list.isEmpty()) {
            board.setReplyList(list);
        }
        return board;
    }

    @Override
    public void insertBoard(Board board) {
        bDao.insertBoard(board);
    }

    @Override
    public void updateBoard(Board board) {
        bDao.updateBoard(board);
    }

    @Override
    public void deleteBoard(int bid) {
        if (bDao.getBoard(bid) != null) {
            bDao.deleteBoard(bid);
        }
    }

    @Override
    public void close() {
        bDao.close();
        rDao.close();
    }
}
