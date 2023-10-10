package com.zero2hero.practice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message = "Owner email is mandatory!!")
    @NotEmpty(message = "Owner email is mandatory!!")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "password is mandatory!!")
    @NotEmpty(message = "password is mandatory!!")
    private String password;
}
