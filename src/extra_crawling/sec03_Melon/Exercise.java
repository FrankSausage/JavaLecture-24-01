package extra_crawling.sec03_Melon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Exercise {
    public static void main(String[] args) throws IOException {
        String url = "https://www.melon.com/chart/index.htm";
        Document doc = Jsoup.connect(url).get();

        String date = doc.selectFirst(".year").text().strip();
        String time = doc.selectFirst(".hour").text().strip();
        System.out.println(date + " - " + time);
    }
}
