package ch18_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Q21_Grep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 문자열: ");
        String search = sc.nextLine();
        System.out.print("찾을 파일: ");
        String fileName = sc.nextLine();
        sc.close();

        grep(search, fileName);
    }


    static void grep(String search, String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            int lineNum = 1;
            while (true){
                String line = br.readLine();
                if(line == null){
                    break;
                }
                String newLine = line.toLowerCase();        // 대소문자 구분하지 않겠다
                if(newLine.contains(search.toLowerCase())){
                    System.out.printf("%4d:\t%s%n",lineNum, line);
                }
                lineNum++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
