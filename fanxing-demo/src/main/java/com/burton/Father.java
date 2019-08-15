package com.burton;


public class Father {
    private int age;
    private String name;

    public void sayMyName() {
        System.out.println(name);
    }

    public Father(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
