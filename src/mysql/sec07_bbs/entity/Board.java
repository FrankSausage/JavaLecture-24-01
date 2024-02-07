package mysql.sec07_bbs.entity;

import java.time.LocalDateTime;

public class Board {
    private int bid;
    private String title;
    private String content;
    private String uid;
    private LocalDateTime modTime;
    private int isDeleted;
    private int viewCount;
    private int replyCount;

    public Board(){ }
    public Board(int bid, String title, String content, String uid, LocalDateTime modTime, int isDeleted, int viewCount, int replyCount) {
        this.bid = bid;
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.modTime = modTime;
        this.isDeleted = isDeleted;
        this.viewCount = viewCount;
        this.replyCount = replyCount;
    }

    @Override
    public String toString() {
        return "Board{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", uid='" + uid + '\'' +
                ", modTime=" + modTime +
                ", isDeleted=" + isDeleted +
                ", viewCount=" + viewCount +
                ", replyCount=" + replyCount +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public LocalDateTime getModTime() {
        return modTime;
    }

    public void setModTime(LocalDateTime modTime) {
        this.modTime = modTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }
}
