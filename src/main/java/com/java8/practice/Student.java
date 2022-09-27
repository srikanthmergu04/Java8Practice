package com.java8.practice;

public class Student {
    private int id;
    private String name;
    private String place;
    private String dept;
    private Integer marks;

    public Student(int id, String name, String place, String dept, Integer marks) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.dept = dept;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", dept='" + dept + '\'' +
                ", marks=" + marks +
                '}';
    }
}
