/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Tasneem
 */
public class Group implements Serializable {

    private int group_id;
    private String name;
    private boolean is_class;
    private java.util.Date created_date;
    private String group_picture;
    private int admin_id;
    private User admin;

    //Setters and Getters Methods:
    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_class() {
        return is_class;
    }

    public void setIs_class(boolean is_class) {
        this.is_class = is_class;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getGroup_picture() {
        return group_picture;
    }

    public void setGroup_picture(String group_picture) {
        this.group_picture = group_picture;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

}
