package com.sanshao.base.bean;

public class Person {

    public Car car;
    public String name;
    public int age;

    public Person(Car car, String name, int age) {
        this.car = car;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
                "car=" + car +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
