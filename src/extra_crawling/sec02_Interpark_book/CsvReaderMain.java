package extra_crawling.sec02_Interpark_book;

import extra_crawling.csv.CsvUtil;
import extra_crawling.csv.CsvUtilImpl;

import java.util.List;

public class CsvReaderMain {
    public static void main(String[] args) {
        CsvUtil csvUtil = new CsvUtilImpl();
        List<List<String>> csvList = csvUtil.readCsv("C:/Test/interpark.tsv", "\t");

        for (List<String> line : csvList) {
            InterparkBook ib = new InterparkBook(Integer.parseInt(line.get(0)),
                    line.get(1), line.get(2), line.get(3),Integer.parseInt((line.get(4))));
            System.out.println(ib);
        }
    }
}
