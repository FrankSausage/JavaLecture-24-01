package ch18_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class Ex02_InputStream {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("C:/Test/README.txt");

        // 읽는 방법1
        while (true) {
            int data = is.read();           // 1바이트를 읽어서 정수형으로 반환
            if (data == -1){                // 마지막
                break;
            }
            System.out.print((char)data);
        }

        // 읽는 방법 2
        is = new FileInputStream(new File("C:/Test/README.txt"));
        byte[] arr = new byte[512];
        while (true){
            int num = is.read(arr);
            System.out.println(" 읽은 바이트 수: " + num);
            if(num == -1){
                break;
            }
            System.out.println(new String(arr));
        }
        is.close();
    }
}
