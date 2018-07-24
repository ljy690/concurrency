package com.jy.concurrency.entity;

import org.springframework.web.client.RestOperations;

public class LombokTest {
    public static void main(String[] args) {
//        User user1 = User.of("JY");
//        //链式调用
//        User user2 = User.of("liaojy").setAge(12);
//
//        System.out.println(user1);
//        System.out.println(user2);

        //建造者模式
        Student student = Student.builder().age(23).userName("test").build();
        System.out.println(student);

        RestOperations
    }
}
