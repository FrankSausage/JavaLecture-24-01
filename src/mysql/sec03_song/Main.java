package mysql.sec03_song;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SongDao songDao = new SongDao();

        Song song = songDao.getSongBySid(101);
        System.out.println(song);

        song = songDao.getSongByTitle("별빛");
        System.out.println(song);
        System.out.println("==============================");

        songDao.insertSong(new Song("Hypeboy", "Hype boy 너만 원해 Hype boy 내가 전해"));
//        song = songDao.getSongBySid(117);
//        song.setTitle("Super Shy");
//        song.setLyrics("I'm super shy, super shy");
//        songDao.updateSong(song);

//        songDao.deleteSong(117);
        List<Song> songList = songDao.getSongListAll();
        songList.forEach(System.out::println);

        songDao.close();
    }
}
