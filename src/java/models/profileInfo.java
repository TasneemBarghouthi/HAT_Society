/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import db_connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tasneem
 */
@ManagedBean
@SessionScoped
public class profileInfo {

    String include = "myPosts.xhtml";
    public User loggedInUser = new User();
    private List<User> friends = new ArrayList<>();
    public List<photo_1> photos = new ArrayList<>();
    public List<post_1> posts = new ArrayList<>();
    public List<post_1> myPosts = new ArrayList<>();

    public List<post_1> getPosts() {
        return posts;
    }

    public List<post_1> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<post_1> myPosts) {
        this.myPosts = myPosts;
    }

    public void setPosts(List<post_1> posts) {
        this.posts = posts;
    }

    public List<User> getFriends() {
        return friends;
    }

    /**
     * A method to check the login operation:
     *
     * @return the name of home page, just if the email and password is correct.
     */
    public void login(int i) {
        loggedInUser.setEmail("h.a.m.hadeel@gmail.com");
        Connection conn = new DB_Connection().getConnection();
        ResultSet res = null;
        try {
            Statement st = conn.createStatement();
            //ensure that the password has been encrypted before checking it in the database.

            String sqlQuery1 = "SELECT `user_id`, `f_name`, `l_name`, `username`, `birthday`, `status`, `university_id`, `picture`, `region`, `gender`, `phone_number` FROM `user_profile` WHERE `user_id`=" + i;
            ResultSet rs2 = st.executeQuery(sqlQuery1);
            if (rs2.next()) {
                loggedInUser.setGender(rs2.getString("gender"));
                loggedInUser.setBirthdate(rs2.getDate("birthday"));
                loggedInUser.setRegion(rs2.getString("region"));
                loggedInUser.setStatus(rs2.getString("status"));
                loggedInUser.setUser_id(rs2.getInt("user_id"));
                loggedInUser.setPhonenumber(rs2.getString("phone_number"));
                loggedInUser.setUsername(rs2.getString("username"));
            } else {
                //Message shows that the login has failed
                System.out.println("Email or password is INCORRECT!!!!!!");
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /**
     * A method to sign up new user:
     *
     * @return the name of home page, just if the operation has completed
     * successfully.
     */
    /**
     * A method to check the confirm password is similar to the original
     * password.
     *
     * @return a string message to show the user a feedback
     */
    public String checkConfirmPassword() {
        //newUser.getPassword(), newUser.getRepassword();  operation on these values
        return "";
    }

    /**
     * A method to code inserted password before saving OR checking it in the
     * database
     */
    public void encryptedPassword() {
        //newUser.getPassword(); operation on this value
        //OR
        //loggedInUser.getPassword(); operation on this value
    }

    // Setters and Getters Methods:
    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void setInclude(String s) {
        if (s.equals("info")) {
            include = "myInfo.xhtml";
        }
        if (s.equals("friends")) {
            include = "myFriends.xhtml";
        }
        if (s.equals("post")) {
            include = "myPosts.xhtml";
        }
        if (s.equals("photos")) {
            include = "myPhotos.xhtml";
        }
    }

    public String getinclude() {
        return include;
    }

    public void gettFriends() {
        friends.clear();
        List<String> ids = new ArrayList<>();

        Connection conn = new DB_Connection().getConnection();
        try {
            Statement st = conn.createStatement();
            //ensure that the password has been encrypted before checking it in the database.
            int userID = 2;
            String sqlQuery1 = "SELECT `user_id1`, `user_id2` FROM `friend` WHERE `user_id1`=" + userID + " OR `user_id2`=" + userID;
            ResultSet rs1 = st.executeQuery(sqlQuery1);

            while (rs1.next()) {
                int user1 = rs1.getInt("user_id1");
                int user2 = rs1.getInt("user_id2");
                System.out.print(user2 + "---" + user1);
                if (user1 != userID) {
                    ids.add(rs1.getInt("user_id1") + "");
                } else {
                    ids.add(rs1.getInt("user_id2") + "");
                }
            }
            for (int i = 0; i < ids.size(); i++) {
                Statement st2 = conn.createStatement();
                //ensure that the password has been encrypted before checking it in the database.
                String sqlQuery2 = "SELECT `username`, `picture` FROM `user_profile` WHERE `user_id`=" + Integer.parseInt(ids.get(i));
                ResultSet rs2 = st2.executeQuery(sqlQuery2);
                if (rs2.next()) {
                    friends.add(new User(rs2.getString("picture"), rs2.getString("username"), Integer.parseInt(ids.get(i))));
                }
            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void gettPhotos() {
        photos.clear();
        List<String> ids = new ArrayList<>();
        Connection conn = new DB_Connection().getConnection();
        try {
            Statement st = conn.createStatement();
            //ensure that the password has been encrypted before checking it in the database.
            int userID = 2;
            String sqlQuery1 = "SELECT `photos_id` FROM `photos_profile` WHERE `user_id`=" + userID + "";
            ResultSet rs1 = st.executeQuery(sqlQuery1);
            while (rs1.next()) {
                System.out.println(rs1.getInt("photos_id"));
                ids.add(rs1.getInt("photos_id") + "");
            }
            for (int i = 0; i < ids.size(); i++) {
                Statement st2 = conn.createStatement();
                //ensure that the password has been encrypted before checking it in the database.
                String sqlQuery2 = "SELECT `picture_url`, `date`, `description` FROM `photo` WHERE `photos_id`=" + Integer.parseInt(ids.get(i));
                ResultSet rs2 = st2.executeQuery(sqlQuery2);
                if (rs2.next()) {
                    System.out.println(i);
                    photos.add(new photo_1(rs2.getString("picture_url"), rs2.getString("description"), rs2.getDate("date"), Integer.parseInt(ids.get(i))));
                }
            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public List<photo_1> getPhotos() {
        return photos;
    }

    public void setPhotos(List<photo_1> photos) {
        this.photos = photos;
    }

    public void gettPost() {
        posts.clear();
        myPosts.clear();
        List<String> ids = new ArrayList<>();
        Connection conn = new DB_Connection().getConnection();
        try {
            Statement st = conn.createStatement();
            //ensure that the password has been encrypted before checking it in the database.
            int userID = 2;
            String sqlQuery1 = "SELECT `post_id` FROM `post_profile` WHERE `profile_id`=" + userID + "";
            ResultSet rs1 = st.executeQuery(sqlQuery1);
            while (rs1.next()) {
                System.out.println(rs1.getInt("post_id"));
                ids.add(rs1.getInt("post_id") + "");
            }
            for (int i = 0; i < ids.size(); i++) {
                Statement st2 = conn.createStatement();
                //ensure that the password has been encrypted before checking it in the database.
                String sqlQuery2 = "SELECT `content`, `post_id`, `date`, `status`, `owner_id` FROM `post` WHERE `post_id`=" + Integer.parseInt(ids.get(i));
                ResultSet rs2 = st2.executeQuery(sqlQuery2);
                if (rs2.next()) {
                    System.out.println(i);
                    if (rs2.getInt("owner_id") == userID) {
                        myPosts.add(new post_1(rs2.getString("content"), rs2.getDate("date"), rs2.getInt("owner_id"), rs2.getString("status"), Integer.parseInt(ids.get(i))));
                    } else {
                        posts.add(new post_1(rs2.getString("content"), rs2.getDate("date"), rs2.getInt("owner_id"), rs2.getString("status"), Integer.parseInt(ids.get(i))));
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
