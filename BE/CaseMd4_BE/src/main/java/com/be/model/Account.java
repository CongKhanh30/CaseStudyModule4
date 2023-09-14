package com.be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    @Column(columnDefinition = "text")
    private String image;
    private LocalDate dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @ManyToOne
    private Role role;
    public int getYearFromDateOfBirth() {
        return this.dateOfBirth.getYear();
    }


}
