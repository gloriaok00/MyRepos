package com.example.demo.pingshi.mylombok;

import lombok.Getter;

import java.beans.ConstructorProperties;

@Getter
public class Student1 {

    private String name;
    private int age;
    private String title;

    @ConstructorProperties({"name", "age", "title"})
    Student1(String name, int age, String title) {
        this.name = name;
        this.age = age;
        this.title = title;
    }

    public static Student1.Student1Builder builder() {
        return new Student1.Student1Builder();
    }

    public static class Student1Builder {
        private String name;
        private int age;
        private String title;

        Student1Builder() {
        }

        public Student1.Student1Builder name(String name) {
            this.name = name;
            return this;
        }

        public Student1.Student1Builder age(int age) {
            this.age = age;
            return this;
        }

        public Student1.Student1Builder title(String title) {
            this.title = title;
            return this;
        }

        public Student1 build() {
            return new Student1(this.name, this.age, this.title);
        }

        public String toString() {
            return "Student1.Student1Builder(name=" + this.name + ", age=" + this.age + ", title=" + this.title + ")";
        }
    }
}
