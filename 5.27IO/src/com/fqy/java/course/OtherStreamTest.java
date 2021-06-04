package com.fqy.java.course;

import org.junit.Test;

import java.io.*;

/**
 * @author fan_jennifer
 * @create 2021-05-2021/5/27 13:42
 */
public class OtherStreamTest {
    //标准的输入输出流
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                System.out.println("请输入字符串:");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;//退出整个循环
                }

                String upperCase = data.toUpperCase();
                System.out.println("upperCase = " + upperCase);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 打印流
     * */
    @Test
    public void test() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("hello.txt"));

            ps = new PrintStream(fos, true);

            if (ps != null) {
                System.setOut(ps);
            }
            /*
             * 安排一行包含多少字
             * */
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);//setOut以后就不会从控制台输出，会变道指定的文件ps
                if (i % 50 == 0) {
                    System.out.println();

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*
     * 数据流
     * */
    @Test
    public void test3() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File("hello.txt")));

            dos.writeUTF("周杰伦");
            dos.flush();
            dos.writeInt(40);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test4() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(new File("hello.txt")));
//读的顺序要根据写的顺序
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("isMale = " + isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

