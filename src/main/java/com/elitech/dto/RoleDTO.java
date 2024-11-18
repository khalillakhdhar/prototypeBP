package com.elitech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RoleDTO {
private long id;
@NotBlank(message = "le nom est obligatoire")
@Size(min = 3,max = 30,message = "le nom doit comporter 3-30 caractéres")
private String name;
}
