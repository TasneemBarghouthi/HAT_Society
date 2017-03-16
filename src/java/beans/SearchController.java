package beans;

import db_connection.DB_Connection;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import models.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author amm
 */
@ManagedBean
@RequestScoped
public class SearchController {

    private List Res;
    private String keyword;
    private User user;

    public List getRes() {
        return Res;
    }

    public void setRes(List Res) {
        this.Res = Res;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List getUsers() {

        List<User> SearchResults = new ArrayList<>();

        if (null == keyword || "".equals(keyword)) {
            return SearchResults;
        }

        Connection cnn = new DB_Connection().getConnection();
        Statement stat;
        String firstname, lastname, username, email;
        SearchResults = getFriends(keyword);

        try {

            stat = cnn.createStatement();

            String sqlQuery = "SELECT * FROM `user_profile`";
            ResultSet res = stat.executeQuery(sqlQuery);
//                System.out.println("find!!!!!!!");
            while (res.next()) {

                firstname = res.getString("f_name");
                lastname = res.getString("l_name");
                username = res.getString("username");

                if (username.equalsIgnoreCase(keyword)) {

                    SearchResults.add(new User(res.getString("picture"), res.getString("username"), Integer.parseInt(res.getString("user_id"))));

                } else if (firstname.equalsIgnoreCase(keyword)) {
                    SearchResults.add(new User(res.getString("picture"), res.getString("username"), Integer.parseInt(res.getString("user_id"))));

                } else if (lastname.equalsIgnoreCase(keyword)) {
                    SearchResults.add(new User(res.getString("picture"), res.getString("username"), Integer.parseInt(res.getString("user_id"))));

                }

            }
            //redirect user to the home page.
            res.close();
            stat.close();
        } catch (SQLException ex) {
//            Logger.getLogger(keyword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SearchResults;
    }

    public List getFriends(String Keyword) {

        List<User> SearchResults = new ArrayList<>();
        Connection conn = new DB_Connection().getConnection();
        try {

            ArrayList<String> ids = new ArrayList<>();
            Statement st = conn.createStatement();
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
            String username = "", firstname = "", lastname = "";
            for (int i = 0; i < ids.size(); i++) {
                Statement st2 = conn.createStatement();
                //ensure that the password has been encrypted before checking it in the database.
                String sqlQuery2 = "SELECT `username`, `picture` FROM `user_profile` WHERE `user_id`=" + Integer.parseInt(ids.get(i).toString());
                ResultSet rs2 = st2.executeQuery(sqlQuery2);
                firstname = rs2.getString("f_name");
                lastname = rs2.getString("l_name");
                username = rs2.getString("username");
                if (rs2.next()) {
                    if (username.equalsIgnoreCase(keyword)) {
                        System.out.println(ids.get(i) + "---" + rs2.getString("picture") + "----" + username);

                        SearchResults.add(new User(rs2.getString("picture"), username, Integer.parseInt(ids.get(i).toString())));
                    } else if (firstname.equalsIgnoreCase(keyword)) {
                        System.out.println(ids.get(i) + "---" + rs2.getString("picture") + "----" + rs2.getString("username"));

                        SearchResults.add(new User(rs2.getString("picture"), username, Integer.parseInt(ids.get(i).toString())));
                    } else if (lastname.equalsIgnoreCase(keyword)) {
                        System.out.println(ids.get(i) + "---" + rs2.getString("picture") + "----" + rs2.getString("username"));

                        SearchResults.add(new User(rs2.getString("picture"), username, Integer.parseInt(ids.get(i).toString())));
                    }

                }
            }

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return SearchResults;
    }
}
