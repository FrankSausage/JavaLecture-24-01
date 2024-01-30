package extra_crawling.sec02_Interpark_book;

import ch12_interface.sec05_default.A;
import extra_crawling.csv.CsvUtil;
import extra_crawling.csv.CsvUtilImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvMain {
    public static void main(String[] args) throws IOException {
        InterparkBookService interparkBookService = new InterparkBookService();
        CsvUtil csvUtil = new CsvUtilImpl();

        List<InterparkBook> list = interparkBookService.getBestSeller();
        List<List<String>> csvList = new ArrayList<>();

        for (InterparkBook ib: list){
            List<String> line = new ArrayList<>();
            line.add(ib.getRank() + "");
            line.add(ib.getTitle());
            line.add(ib.getAuthor());
            line.add(ib.getCompany());
            line.add(ib.getPrice() + "");
            csvList.add(line);
        }
        csvUtil.writeCsv("c:/Test/interpark.tsv", csvList, "\t");

    }
}
