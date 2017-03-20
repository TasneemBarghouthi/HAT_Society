package beans;

import db_connection.DB_Connection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import models.CClass;
import models.EEvent;
import models.Group;
import models.Page;
import models.Post;
import models.User;

/**
 *
 * @author Tasneem
 */
@ManagedBean
@ViewScoped
public class PostBean implements Serializable {

    Connection cnn = new DB_Connection().getConnection();
    Statement stat;
    Post post = new Post();
    User postOwner = new User();
    User postUserProfile = new User();
    Post newPost = new Post();
    List<Post> listOfAllPostsOfCurrentView = new ArrayList<>();

    /**
     * Initialization Method:
     */
    public void init() {
//        getLoggedInUserID
//        loadPostsOfHomeView();
        post = new Post();
        post.setPostId(1);
        post.setContent("POSTED!!");
        post.setDate(new java.util.Date());
        post.setOwnerId(1);
        postOwner.setFirst_name("Hat");
        postOwner.setLast_name("Hat");
        postOwner.setUsername("HAT");
        postOwner.setPicture_url("pic");
        post.setOwnerIdUser(postOwner);

        for (int i = 0; i < 10; i++) {
            listOfAllPostsOfCurrentView.add(post);
        }
    }

    /**
     * A method to add new post to database and the list of posts and publish it
     */
    public void addNewPost() {

    }

    /**
     * A method to like/unlike a post
     *
     * @param post
     */
    public void newPostLike(Post post) {

    }

    /**
     * A method to comment to a post
     *
     * @param post
     */
    public void newPostComment(Post post) {

    }

    /**
     * A method to share to a post
     *
     * @param post
     */
    public void newPostShare(Post post) {

    }

    /**
     * A method to load posts from database and save them in the list of posts
     * of logged in user ((PROFILE)) view "any profile - in general":
     *
     * @param user_profile
     */
    public void loadPostsOfProfileView(User user_profile) {
        try {
            stat = cnn.createStatement();
            String sqlQuery = "SELECT * FROM `hat_society`.`user_profile_post` WHERE user_id = '" + user_profile.getUser_id() + "'";
            ResultSet res = stat.executeQuery(sqlQuery);
            while (res.next()) {
                String sqlQueryPost = "SELECT * FROM `hat_society`.`post` WHERE post_id = '" + res.getInt("post_id") + "'";
                ResultSet resPost = stat.executeQuery(sqlQueryPost);
                if (resPost.next()) {
                    post = new Post();
                    post.setPostId(resPost.getInt("post_id"));
                    post.setContent(resPost.getString("content"));
                    post.setDate(new java.util.Date(resPost.getDate("date").getTime()));
                    post.setOwnerId(resPost.getInt("owner_id"));
                    String sqlQueryPostOwner = "SELECT * FROM `hat_society`.`user_profile` WHERE user_id = '" + post.getOwnerId() + "'";
                    ResultSet resPostOwner = stat.executeQuery(sqlQueryPostOwner);
                    if (resPostOwner.next()) {
                        postOwner = new User();
                        postOwner.setFirst_name(resPostOwner.getString("f_name"));
                        postOwner.setLast_name(resPostOwner.getString("l_name"));
                        postOwner.setUsername(resPostOwner.getString("username"));
                        postOwner.setPicture_url(resPostOwner.getString("picture"));
                        post.setOwnerIdUser(postOwner);
                        listOfAllPostsOfCurrentView.add(post);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * A method to load posts from database and save them in the list of posts
     * of logged in user ((HOME)) view:
     *
     * @param loggedInUser
     */
    public void loadPostsOfHomeView(User loggedInUser) {

    }

    /**
     * A method to load posts from database and save them in the list of posts
     * of logged in user ((CLASS)) view:
     *
     * @param cclass
     */
    public void loadPostsOfClassView(CClass cclass) {

    }

    /**
     * A method to load posts from database and save them in the list of posts
     * of logged in user ((GROUP)) view:
     *
     * @param group
     */
    public void loadPostsOfGroupView(Group group) {

    }

    /**
     * A method to load posts from database and save them in the list of posts
     * of logged in user ((PAGE)) view:
     *
     * @param page
     */
    public void loadPostsOfPageView(Page page) {

    }

    /**
     * A method to load posts from database and save them in the list of posts
     * of logged in user ((EVENT)) view:
     *
     * @param eevent
     */
    public void loadPostsOfEventView(EEvent eevent) {

    }

    //Setters and Getters Methods:
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getPostOwner() {
        return postOwner;
    }

    public void setPostOwner(User postOwner) {
        this.postOwner = postOwner;
    }

    public User getPostUserProfile() {
        return postUserProfile;
    }

    public void setPostUserProfile(User postUserProfile) {
        this.postUserProfile = postUserProfile;
    }

    public Post getNewPost() {
        return newPost;
    }

    public void setNewPost(Post newPost) {
        this.newPost = newPost;
    }

    public List<Post> getListOfAllPostsOfCurrentView() {
        return listOfAllPostsOfCurrentView;
    }

    public void setListOfAllPostsOfCurrentView(List<Post> listOfAllPostsOfCurrentView) {
        this.listOfAllPostsOfCurrentView = listOfAllPostsOfCurrentView;
    }

}
