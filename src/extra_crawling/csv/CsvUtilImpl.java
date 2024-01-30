package extra_crawling.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtilImpl implements CsvUtil {
    @Override
    public List<List<String>> readCsv(String fileName) {
        return readCsv(fileName, ",", 0);
    }

    @Override
    public List<List<String>> readCsv(String fileName, String separator) {
        return readCsv(fileName, separator, 0);
    }

    @Override
    public List<List<String>> readCsv(String fileName, int skipLine) {
        return readCsv(fileName, ",", skipLine);
    }

    @Override
    public List<List<String>> readCsv(String fileName, String separator, int skipLine) {
        List<List<String>> csvList = new ArrayList<>();
        BufferedReader br = null;
        int lineNum = 0;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while (true){
                String line = br.readLine();
                if(line == null){
                    break;
                }
                if(skipLine > lineNum++){
                    continue;
                }
                String[] lineArray = line.split(separator);
                csvList.add(Arrays.asList(lineArray));
//                List<String> lineList = new ArrayList<>();
//                for(String word: lineArray){
//                    lineList.add(word);
//                    csvList.add(lineList);
//                }
            }
        } catch (Exception e){
          e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return csvList;
    }

    @Override
    public void writeCsv(String fileName, List<List<String>> dataList) {
        writeCsv(fileName, dataList, ",");
    }

    @Override
    public void writeCsv(String fileName, List<List<String>> dataList, String separator) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));
            for (List<String> data : dataList) {
                String line = "";
                for (int i = 0; i < data.size(); i++) {
                    line += data.get(i);
                    if (i < data.size() - 1) {
                        line += separator;
                    }
                }
                bw.write(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.flush();
                bw.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
}
