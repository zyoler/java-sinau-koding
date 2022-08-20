package com.example.Bootcamp.SinauKoding.model.dto;

import com.example.Bootcamp.SinauKoding.model.DetailUser;
import com.example.Bootcamp.SinauKoding.model.RoleUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String username;
    private String profileName;
    private String address;
    private String phone;
}
