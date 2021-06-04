package com.fqy.java.course;

import org.junit.Test;

import java.io.*;

/**
 * @author fan_jennifer
 * @create 2021-05-2021/5/27 10:35
 */
public class BufferedTest {

    @Test
    public void testBufferedReaderBufferedWriter() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello1.txt")));
//读写操作方式一
          /*  char[] cbuf = new char[1024];
            int len;
            while ((len = br.read(cbuf)) != -1) {
                bw.write(cbuf,0,len);*/
                //读写操作方式二
                String data;
                while ((data = br.readLine() )!= null) {
                    bw.write(data);
                }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
