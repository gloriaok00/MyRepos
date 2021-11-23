package com.example.demo.pingshi.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangyu
 * @date 2019/12/11 13:20
 */
public class TestJVMInfo {

    public static void main(String[] args) throws IOException{



        /*byte[] bytes = {65, 66, 67, 68, 69};
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/com/example/demo/pingshi/io/test.txt");
        fileOutputStream.write(bytes);
        fileOutputStream.close();

        FileReader fileReader = new FileReader("src/main/java/com/example/demo/pingshi/io/test.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
        fileReader.close();
        bufferedReader.close();*/

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/main/java/com/example/demo/pingshi/io/input.txt");
            out = new FileOutputStream("src/main/java/com/example/demo/pingshi/io/output.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
