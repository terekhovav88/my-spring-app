package com.example.web.dao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class RegistrationForm {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Size(min=3, max=30)
    private String surname;

    @Email(message = "Email should be valid")
    private String mail;

    @NotNull
    @Size(min=7, max=30)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }


//    public String toString() {
//        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
//    }
}