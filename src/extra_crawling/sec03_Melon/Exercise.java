package extra_crawling.sec03_Melon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exercise {
    public static void main(String[] args) throws IOException {
        String url = "https://www.melon.com/chart/index.htm";
        Document doc = Jsoup.connect(url).get();
        Elements trs = doc.select(".service_list_song.type02.d_song_list > table > tbody > tr");
//        System.out.println(trs.size());

        List<MelonChart> list = new ArrayList<>();
        for (Element tr: trs){

            String rank_ = tr.selectFirst(".rank").text().strip();
            int rank = Integer.parseInt(rank_);
            String title = tr.selectFirst(".ellipsis.rank01 > span > a").text().strip();
            String artist = tr.selectFirst(".ellipsis.rank02 > a").text().strip();
            String album = tr.selectFirst(".ellipsis.rank03 > a").text().strip();
            String src = tr.selectFirst("td:nth-child(4) > div > a > img").attr("src");
            list.add(new MelonChart(rank, title, artist, album, src));
        }

        for (MelonChart m : list){
            System.out.println(m);
        }


    }
}
