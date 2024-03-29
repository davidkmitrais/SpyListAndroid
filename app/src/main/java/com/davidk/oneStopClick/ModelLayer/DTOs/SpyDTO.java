package com.davidk.oneStopClick.ModelLayer.DTOs;

import com.davidk.oneStopClick.ModelLayer.Enums.DTOType;
import com.davidk.oneStopClick.ModelLayer.Enums.Gender;

import java.util.Random;

public class SpyDTO {

    public static DTOType dtoType = DTOType.spy;

    public int id;
    public int age;
    public String name;
    public Gender gender;
    public String password;
    public String imageName;
    public boolean isIncognito;

    public SpyDTO(int id, int age, String name, Gender gender, String password, String imageName, boolean isIncognito) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.password = password;
        this.imageName = imageName;
        this.isIncognito = isIncognito;
    }

    public static String imageNameFor(Gender gender) {

        int min = 1;
        int max = 6;

        Random r = new Random();
        int imageIndex = r.nextInt(max - min + 1) + min;

        String imageGender = gender == Gender.female
                           ? "F"
                           : "M";

        return String.format("Spy%s%02d", imageGender, imageIndex).toLowerCase();
    }


    @Override
    public String toString() {
        return "SpyDTO{" +
                " id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", isIncognito=" + isIncognito +
                '}';
    }

    public void initialize() {
        this.imageName = imageNameFor(gender);
    }
}
