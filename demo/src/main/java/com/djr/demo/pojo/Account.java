package com.djr.demo.pojo;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;
    private String password;
    private int gender;  //0: female,1 : male
    private String birthDate;
    private String place;
    private String mobile;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;

        return  Objects.equals(getId(), account.getId()) &&
                getGender() == account.getGender() &&
                getName().equals(account.getName()) &&
                getPassword().equals(account.getPassword()) &&
                Objects.equals(getBirthDate(),account.getBirthDate()) &&
                Objects.equals(getPlace(), account.getPlace()) &&
                Objects.equals(getMobile(), account.getMobile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPassword(), getGender(), getBirthDate(), getPlace(), getMobile());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", place='" + place + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
