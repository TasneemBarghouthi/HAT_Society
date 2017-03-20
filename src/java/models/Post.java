/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import models.User;

/**
 *
 * @author Tasneem
 */
public class Post {

    private Integer postId;
    private String content;
    private java.util.Date date;
    private String status;
    private int ownerId;
    private User ownerIdUser;

    //Setters and Getters Methods
    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public User getOwnerIdUser() {
        return ownerIdUser;
    }

    public void setOwnerIdUser(User ownerIdUser) {
        this.ownerIdUser = ownerIdUser;
    }

}
