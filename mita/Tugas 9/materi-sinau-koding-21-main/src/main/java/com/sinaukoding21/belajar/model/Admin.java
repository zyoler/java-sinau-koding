package com.sinaukoding21.belajar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_name")
    private String profileName;

    @Column(name = "address")
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @Column(name = "phone")
    private String phone;
}
