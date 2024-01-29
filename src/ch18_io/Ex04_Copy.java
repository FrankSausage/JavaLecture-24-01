package ch18_io;

import java.io.*;

public class Ex04_Copy {

    public static void main(String[] args) throws Exception {
        String srcFile = "C:/Test/cat.jpg", dstFile = "c:/Test/고양이.jpg";
        InputStream is = new FileInputStream(srcFile);
        OutputStream os = new FileOutputStream(dstFile);

        byte[] buffer = new byte[4096];
        while (true){
            int num = is.read(buffer);
            if (num == -1){
                break;
            }
            os.write(buffer, 0, num);
        }
        os.flush(); os.close(); is.close();
        System.out.println("Copy is done!");
    }
}
