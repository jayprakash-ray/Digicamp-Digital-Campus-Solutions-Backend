package com.digicamp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
//import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name ="uid")
    private Integer uuid;

    @NotNull
    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "Email cannot be empty")
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull
    @NumberFormat(pattern = "[6789][0-9]{9}")
    @NotEmpty(message = "Mobile number cannot be empty")
    @Column(unique = true, nullable = false)
    private String mobile1;

    @NumberFormat(pattern = "[6789][0-9]{9}")
    private String mobile2;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Roll number cannot be null")
    private String rollNumber;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, message = "Password must be atleast {min} characters long")
    @Column(name = "password", nullable = false)
    private String password;

//    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
//    @Column(name = "status", nullable = false)
//    private Integer status = 0;
    @ManyToOne
    @JoinColumn(name="role", nullable = false)
    private Role role;

    public User() {
    }


    public User(Integer uuid, String userId, String name, String mobile1, String mobile2, String rollNumber, String password, Role role) {
        this.uuid = uuid;
        this.userId = userId;
        this.name = name;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.rollNumber = rollNumber;
        this.password = password;
        this.role = role;
    }

    public User(String userId, String name, String mobile1, String mobile2, String rollNumber, String password, Role role) {
        this.userId = userId;
        this.name = name;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.rollNumber = rollNumber;
        this.password = password;
        this.role = role;
    }



    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", mobile1='" + mobile1 + '\'' +
                ", mobile2='" + mobile2 + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
