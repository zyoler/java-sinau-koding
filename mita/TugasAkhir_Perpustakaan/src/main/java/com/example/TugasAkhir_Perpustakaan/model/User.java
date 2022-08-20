package com.example.TugasAkhir_Perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;

    @Transient
    @OneToOne(mappedBy = "user",fetch=FetchType.EAGER)
    private Anggota anggota;

    @Transient
    @OneToOne(mappedBy = "user",fetch = FetchType.EAGER)
    private Petugas petugas;
}
