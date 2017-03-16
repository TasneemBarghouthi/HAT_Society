/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ham
 */
public class photo_1 implements Serializable{
    int photo_id;
    String photo_url;
    String description;
    Date date;
    
    public photo_1(String s1,String s2,Date date,int i){
    this.photo_url=s1;
    this.description=s2;
    this.date=date;
    this.photo_id=i;
}
    public photo_1(){
    
}
    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
