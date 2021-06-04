package com.fqy.java.course;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author fan_jennifer
 * @create 2021-05-2021/5/27 16:59
 */
public class RandomAccessFileTest {
    @Test
    public void test() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {//1
            raf1 = new RandomAccessFile(new File("bjyxszd.jpg"), "r");
            raf2 = new RandomAccessFile(new File("bjyxszd2.jpg"), "rw");
//2
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);

            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//3
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello1.txt", "rw");

            raf1.seek(3);
            raf1.write("xyz".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    //插入，挺费内存
    @Test
    public void test2() {
        RandomAccessFile raf1 = null;
        try {
            File file = new File("hello1.txt");
            raf1 = new RandomAccessFile(file, "rw");

            raf1.seek(3);

            StringBuilder builder = new StringBuilder((int) file.length());
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf1.read(buffer))!= -1){
                builder.append(new String(buffer,0,len));

            }

            raf1.seek(3);
            raf1.write("xyz".getBytes());

            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
