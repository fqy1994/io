package com.fqy.java.course;

import java.io.Serializable;

/**
 * @author fan_jennifer
 * @create 2021-05-2021/5/27 16:29
 */
public class Person implements Serializable {
        private static final long serialVersionUID = 5343242L;

        private String name;
        private int age;

        public Person() {

        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

