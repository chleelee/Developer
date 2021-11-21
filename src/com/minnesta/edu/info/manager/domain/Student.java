package com.minnesta.edu.info.manager.domain;

public class Student {
    private String id;
    private String name;
    private String age;
    private String addr;

    public Student() {
    }

    public Student(String id, String name, String age, String addr) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }


}
