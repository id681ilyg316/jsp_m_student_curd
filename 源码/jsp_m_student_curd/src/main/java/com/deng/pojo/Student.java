package com.deng.pojo;

/*id     int auto_increment
        primary key,
        name   varchar(255) not null,
        age    int          not null,
        addr   varchar(255) not null,
        gender varchar(255) null*/

public class Student {
    private Integer id;
    private String name;
    private int age;
    private String addr;
    private String gender;

    public Student() {
    }

    public Student(String name, int age, String addr, String gender) {
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.gender = gender;
    }

    public Student(Integer id, String name, int age, String addr, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
