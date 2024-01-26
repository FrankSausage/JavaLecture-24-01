package extra_crawling.sec03_Melon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Exercise {
    public static void main(String[] args) throws IOException {
        String url = "https://www.melon.com/chart/index.htm";
        Document doc = Jsoup.connect(url).get();


        Elements trs = doc.select(".service_list_song.type02.d_song_list > table > tbody > tr");
        System.out.println(trs.size());

        Element tr = trs.get(0);
        String rank_ = tr.selectFirst(".rank").text().strip();
        int rank = Integer.parseInt(rank_);
        String title = tr.selectFirst(".ellipsis.rank01 > span > a").text().strip();
        String artist = tr.selectFirst("ellipsis.rank02 > a").text().strip();
        String album = tr.selectFirst("ellipsis.rank03 > a").text().strip();
        String src = tr.selectFirst("#lst50 > td:nth-child(4) > div > a > img").text().strip();
    }
}
