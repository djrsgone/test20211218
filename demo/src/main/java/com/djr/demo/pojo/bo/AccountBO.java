package com.djr.demo.pojo.bo;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AccountBO {

    private Integer id;

    @NotBlank
    @Length(min=1, max=255, message = "Name Length should be between 1 and 255.")
    private String name;

    @NotBlank
    @Length(min=1, max=20, message = "Password Length should be 1 and 20")
    private String password;

    @Min(value = 1, message = "Gender should be greater than 1")
    @Max(value = 9, message = "Gender should be less than 9")
    private int gender;  //0: female,1 : male

    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="Birth Date is illegal")
    private String birthDate;

    @Length(max=255, message = "Place Length should be between 1 and 255.")
    private String place;

    @Length(max=64, message = "Mobile Length should be between 1 and 64.")
    private String mobile;

    //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
