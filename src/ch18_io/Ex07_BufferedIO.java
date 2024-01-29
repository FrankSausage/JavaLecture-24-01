package ch18_io;

import java.io.*;

public class Ex07_BufferedIO {

    public static void main(String[] args) throws Exception {
        // buffer를 썼을 때와 안썼을 때 비교

        // Case 1) 미사용
        InputStream is = new FileInputStream("c:/Test/eiffel.jpg");
        OutputStream os = new FileOutputStream("c:/Test/에펠.jpg");

        long noBufferTime = copy(is, os);
        System.out.println("버퍼 미사용: " + noBufferTime + " ns");      // 107168000
        is.close(); os.close();

        // Case 2) 사용
        is = new BufferedInputStream(new FileInputStream("c:/Test/eiffel.jpg"));
       os = new BufferedOutputStream(new FileOutputStream("c:/Test/에펠.jpg"));

        long BufferTime = copy(is, os);
        System.out.println("버퍼 사용: " + BufferTime + " ns");     // 2284600
        is.close(); os.close();
    }

    static long copy(InputStream is, OutputStream os) throws IOException {
        long startTime = System.nanoTime();
        // 1 바이트씩 읽고 쓰기
        while (true){
            int data = is.read();
            if (data == -1){
                break;
            }
            os.write(data);
        }
        os.flush();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
