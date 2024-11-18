package com.elitech.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String email;
private String password;
@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinTable(name = "user_roles", joinColumns= @JoinColumn(name="user_id"),
inverseJoinColumns = @JoinColumn(name="role_id"))
@JsonIgnore
private Set<Role> roles;
}
