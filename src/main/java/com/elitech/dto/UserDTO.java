package com.elitech.dto;

import java.util.Set;

import com.elitech.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
private long id;
@NotBlank(message = "le nom est obligatoire")
@Size(min = 3,max = 50,message = "le nom doit comporter 3-50 caractéres")
private String name;
@NotBlank(message = "le email est obligatoire")
@Email(message = "veuillez saisir un email valid")
private String email;
@NotBlank(message = "le mot de passe est obligatoire ")
@Size(min = 8,message = "le mot de passe doit avoir au moins 8 caractéres")
private String password;

private Set<Role> roles; 

}
