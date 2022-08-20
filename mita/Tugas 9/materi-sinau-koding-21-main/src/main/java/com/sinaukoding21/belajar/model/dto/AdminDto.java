package com.sinaukoding21.belajar.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    private Integer id;
    private String username;
    private String password;
    private String profileName;
    private String address;
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
}
