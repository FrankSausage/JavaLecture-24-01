package ch18_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class Ex08_BufferdReader {
    public static void main(String[] args) throws Exception {
        // 줄 단위로 읽을 수 있음
        BufferedReader br = new BufferedReader(new FileReader("C:/Test/README.txt"));

        int lineNumber = 1;
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            System.out.println(lineNumber + ": " + line);
            lineNumber++;
        }
        br.close();
    }
}
