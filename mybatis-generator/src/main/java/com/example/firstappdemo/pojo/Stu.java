package com.example.firstappdemo.pojo;

import javax.persistence.*;

@Table(name="stu")
public class Stu {
    @Id
    private String id;

    private String nane;

    private Integer sex;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return nane
     */
    public String getNane() {
        return nane;
    }

    /**
     * @param nane
     */
    public void setNane(String nane) {
        this.nane = nane == null ? null : nane.trim();
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }
}