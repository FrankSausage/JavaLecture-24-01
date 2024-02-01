package test.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Q1_WordCounter {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 파일> ");
        String filename = sc.nextLine();
        sc.close();
        BufferedReader br = new BufferedReader(new FileReader(filename));

        Set<String> wordSet = new HashSet<>();
        List<String> wordList = new ArrayList<>();
        String line = null;
        int count = 0;
        while ((line = br.readLine()) != null){
            count += line.length();
            String cleanText = line.replaceAll("[^0-9A-Za-zㄱ-ㅎㅏ-ㅣ가-힣]", " ");
            String[] cleanWords = cleanText.split("\\s+");
            for(String word: cleanWords){
                if(word.equals("")){
                    continue;
                }
            }

        }
        System.out.println();
        System.out.println();
    }
}
