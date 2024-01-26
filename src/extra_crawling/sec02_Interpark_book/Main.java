package extra_crawling.sec02_Interpark_book;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        InterparkBookService ib = new InterparkBookService();
        List<InterparkBook> list = ib.getBestSeller();
        list.forEach(System.out::println);
    }
}
