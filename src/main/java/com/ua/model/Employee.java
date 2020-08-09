package com.ua.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;

	// if field not blank - show this message
	@NotBlank(message = "Please enter your first name!")
	//checking on equality with regular expression
	@Pattern(regexp = "^[A-Z]+[a-z]{1,15}|[а-щА-ЩЬьЮюЯяЇїІіЄєҐґ]{1,15}", message = "Invalid firstname")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Please enter your last name!")
	@Pattern(regexp = "^[A-Z]+[a-z]{1,15}|[а-щА-ЩЬьЮюЯяЇїІіЄєҐґ]{1,15}", message = "Invalid lastname")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "Please enter your email!")
	//limiting the max number of symbols
	@Length(max = 30, message = " Can`t have more than 30 symbols ")
	@Pattern(regexp = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$", message = "Invalid email")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "Please enter your login!")
	@Column(name = "login")
	private String login;



	@NotBlank(message = "Please enter your password!")
	@Column(name = "password")
	private String password;

	@Column(name = "birthday")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate  birthday;

	@Column(name = "about")
	@Length(max = 60, message = " Can`t have more than 60 symbols ")
	private String about;

	@Length(max = 30, message = " Can`t have more than 30 symbols ")
	@Column(name = "address")
	private String address;


}
