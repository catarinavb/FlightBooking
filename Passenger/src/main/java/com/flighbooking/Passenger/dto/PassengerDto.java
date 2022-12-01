package com.flighbooking.Passenger.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PassengerDto {

    @NotBlank
    private String firstname;
    @NotBlank
    private String surname;
    @NotBlank
    private String nationality;
    @NotNull
    //@Size(min = 9, max = 9)
    private int nif;
    @NotNull
    //@Size(min = 1, max = 2)
    private int age;

    @Override
    public String toString() {
        return "PassengerDto{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nif=" + nif +
                ", age=" + age +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
