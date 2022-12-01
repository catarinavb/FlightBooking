package com.flighbooking.Passenger.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="passenger")
public class PassengerModel {

    //Try SEQUENCE instead of AUTO or IDENTITY, due to @Transactional in passengerService
    //TODO check validations not working and also lombok with getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer passengerId;
    @Column(nullable = false, length = 20)
    private String firstname;
    @Column(nullable = false, length = 20)
    private String surname;
    //private String name = firstname + " " + surname;
    @Column(nullable = false, length = 20)
    private String nationality;
    @Column(nullable = false, unique = true)
    //@Size(min = 9, max = 9)
    private int nif;
    @Column(nullable = false)
    //@Size(min = 1, max = 2)
    private int age;
    @Column(nullable = false)
    private LocalDateTime registrationDate;


    @Override
    public String toString() {
        return "PassengerModel{" +
                "passengerId=" + passengerId +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nif=" + nif +
                ", age=" + age +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
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

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
