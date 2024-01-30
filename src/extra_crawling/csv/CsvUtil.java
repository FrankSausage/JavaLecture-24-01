package extra_crawling.csv;

import java.util.List;

public interface CsvUtil {
    List<List<String>> readCsv(String fileName);
    List<List<String>> readCsv(String fileName, String separator);
    List<List<String>> readCsv(String fileName, int skipLine);
    List<List<String>> readCsv(String fileName, String separator, int skipLine);

    void writeCsv(String fileName, List<List<String>> dataList);
    void writeCsv(String fileName, List<List<String>> dataList, String separator);
}
