package com.fqy.java.course;

import org.junit.Test;

import java.io.*;

/**
 * @author fan_jennifer
 * @create 2021-05-2021/5/27 16:03
 */
public class ObjectInputOutputStreamTest {

    /*
     * 序列化
     * */
    @Test
    public void test() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("并肩于雪山之巅"));
            oos.flush();

            oos.writeObject(new Person("周杰伦", 45));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void test1() {
        ObjectInputStream ois = null;//不用file吗
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object object = ois.readObject();
            String s = (String) object;
            System.out.println("s = " + s);

            Person person = (Person) ois.readObject();
            System.out.println("person = " + person);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
