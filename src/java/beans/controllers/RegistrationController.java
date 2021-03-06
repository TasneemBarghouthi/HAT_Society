package beans.controllers;

import db_connection.DB_Connection;
import models.User;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Tasneem
 */
@ManagedBean
@SessionScoped
public class RegistrationController implements Serializable {

    Connection cnn = new DB_Connection().getConnection();
    boolean loggedIn = false;
    User loggedInUser = new User();

    /**
     * A method to check the login operation:
     *
     * @return the name of home page, just if the email and password is correct.
     */
    public String login() {
        Statement stat;
        try {
            stat = cnn.createStatement();
            //ensure that the password has been encrypted before checking it in the database.
            String sqlQuery = "SELECT * FROM `hat_society`.`user_account` WHERE `email` LIKE '" + loggedInUser.getEmail() + "' AND `password` LIKE '" + loggedInUser.getPassword() + "'";
            ResultSet res = stat.executeQuery(sqlQuery);
            if (res.next()) {
                System.out.println("LOGGEEEEEED!!!!!!!!");
                //redirect user to the home page.
                loggedIn = true;
                loggedInUser.setUser_id(res.getInt("user_id"));
                String sqlQuery2 = "SELECT * FROM `hat_society`.`user_profile`";
                ResultSet res2 = stat.executeQuery(sqlQuery2);
                if (res2.next()) {
                    loggedInUser.setFirst_name(res2.getString("f_name"));
                    loggedInUser.setLast_name(res2.getString("l_name"));
                    loggedInUser.setUsername(res2.getString("username"));
                    loggedInUser.setBirthdate(new java.util.Date(res2.getDate("birthday").getTime()));
                    loggedInUser.setUniversity_id(res2.getInt("university_id") + "");
                    loggedInUser.setStatus(res2.getString("status"));
                    loggedInUser.setPicture_url(res2.getString("picture"));
                    loggedInUser.setGender(res2.getString("gender"));
                    loggedInUser.setPhonenumber(res2.getString("phone_number"));
                    loggedInUser.setRegion(res2.getString("region"));
                    return "/views/home?faces-redirect=true";
                } else {
                    //Message shows that the login has not completed
                    System.out.println("SOMETHING WENT WRONG!!!");
                }
            } else {
                //Message shows that the login has failed
                System.out.println("Email or password is INCORRECT!!!!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * A method to end session and logout:
     *
     * @return the login page name.
     */
    public String logout() {
        loggedIn = false;
        loggedInUser = new User();
        return "/views/registration/login?faces-redirect=true";
    }

    /**
     * A method to sign up new user:
     *
     * @return the name of home page, just if the operation has completed
     * successfully.
     */
    public String signUp() {
        PreparedStatement prestat;
        try {
            //we have to check the date because a NullPointerException is occured when the date is null so, the query will not occur.
            if (loggedInUser.getBirthdate() != null) {
                String sqlQuery = "INSERT INTO `hat_society`.`user_profile`(`f_name`, `l_name`, `username`, `birthday`, `status`, `university_id`, `picture`, `region`, `gender`, `phone_number`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                //'" + loggedInUser.getFirst_name() + "','" + loggedInUser.getLast_name() + "','" + loggedInUser.getUsername() + "','" + new java.sql.Date(loggedInUser.getBirthdate().getTime()) + "','" + loggedInUser.getStatus() + "','" + loggedInUser.getUniversity_id() + "','" + loggedInUser.getPicture_url() + "','" + loggedInUser.getRegion() + "','" + loggedInUser.getGender() + "','" + loggedInUser.getPhonenumber() + "'
                prestat = cnn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
                prestat.setString(1, loggedInUser.getFirst_name());
                prestat.setString(2, loggedInUser.getLast_name());
                prestat.setString(3, loggedInUser.getUsername());
                prestat.setDate(4, new java.sql.Date(loggedInUser.getBirthdate().getTime()));
                prestat.setString(5, loggedInUser.getStatus());
                prestat.setString(6, loggedInUser.getUniversity_id());
                prestat.setString(7, loggedInUser.getPicture_url());
                prestat.setString(8, loggedInUser.getRegion());
                prestat.setString(9, loggedInUser.getGender());
                prestat.setString(10, loggedInUser.getPhonenumber());
                prestat.executeUpdate();
                ResultSet rs = prestat.getGeneratedKeys();
                if (rs.next()) {
                    //get last inserted user_id, because it is a foreign key in user_account table
                    int last_inserted_id = rs.getInt(1);
                    //ensure that the password has been encrypted before saving it in the database.
                    sqlQuery = "INSERT INTO `user_account`(`user_id`, `email`, `password`) VALUES ('" + last_inserted_id + "','" + loggedInUser.getEmail() + "','" + loggedInUser.getPassword() + "')";
                    Statement stat = cnn.createStatement();
                    stat.executeUpdate(sqlQuery);
                    loggedIn = true;
                    return "/views/home?faces-redirect=true";
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

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
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
