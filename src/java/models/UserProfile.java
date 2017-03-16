/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tasneem
 */
@Entity
@Table(name = "user_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")
    , @NamedQuery(name = "UserProfile.findByUserId", query = "SELECT u FROM UserProfile u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserProfile.findByFName", query = "SELECT u FROM UserProfile u WHERE u.fName = :fName")
    , @NamedQuery(name = "UserProfile.findByLName", query = "SELECT u FROM UserProfile u WHERE u.lName = :lName")
    , @NamedQuery(name = "UserProfile.findByUsername", query = "SELECT u FROM UserProfile u WHERE u.username = :username")
    , @NamedQuery(name = "UserProfile.findByBirthday", query = "SELECT u FROM UserProfile u WHERE u.birthday = :birthday")
    , @NamedQuery(name = "UserProfile.findByStatus", query = "SELECT u FROM UserProfile u WHERE u.status = :status")
    , @NamedQuery(name = "UserProfile.findByUniversityId", query = "SELECT u FROM UserProfile u WHERE u.universityId = :universityId")
    , @NamedQuery(name = "UserProfile.findByRegion", query = "SELECT u FROM UserProfile u WHERE u.region = :region")
    , @NamedQuery(name = "UserProfile.findByGender", query = "SELECT u FROM UserProfile u WHERE u.gender = :gender")
    , @NamedQuery(name = "UserProfile.findByPhoneNumber", query = "SELECT u FROM UserProfile u WHERE u.phoneNumber = :phoneNumber")})
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "f_name")
    private String fName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "l_name")
    private String lName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "university_id")
    private int universityId;
    @Lob
    @Size(max = 16777215)
    @Column(name = "picture")
    private String picture;
    @Size(max = 45)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToMany(mappedBy = "userProfileList")
    private List<Course> courseList;
    @ManyToMany(mappedBy = "userProfileList")
    private List<Msg> msgList;
    @ManyToMany(mappedBy = "userProfileList")
    private List<Post> postList;
    @ManyToMany(mappedBy = "userProfileList1")
    private List<Post> postList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderId")
    private List<Msg> msgList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Questionnaire> questionnaireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recieverId")
    private List<FriendRequest> friendRequestList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderId")
    private List<FriendRequest> friendRequestList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Comment> commentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    private List<Page> pageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private List<Event> eventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<PageFan> pageFanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    private List<Group1> group1List;

    public UserProfile() {
    }

    public UserProfile(Integer userId) {
        this.userId = userId;
    }

    public UserProfile(Integer userId, String fName, String lName, String username, String status, int universityId, String gender, String phoneNumber) {
        this.userId = userId;
        this.fName = fName;
        this.lName = lName;
        this.username = username;
        this.status = status;
        this.universityId = universityId;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlTransient
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @XmlTransient
    public List<Msg> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Msg> msgList) {
        this.msgList = msgList;
    }

    @XmlTransient
    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @XmlTransient
    public List<Post> getPostList1() {
        return postList1;
    }

    public void setPostList1(List<Post> postList1) {
        this.postList1 = postList1;
    }

    @XmlTransient
    public List<Msg> getMsgList1() {
        return msgList1;
    }

    public void setMsgList1(List<Msg> msgList1) {
        this.msgList1 = msgList1;
    }

    @XmlTransient
    public List<Questionnaire> getQuestionnaireList() {
        return questionnaireList;
    }

    public void setQuestionnaireList(List<Questionnaire> questionnaireList) {
        this.questionnaireList = questionnaireList;
    }

    @XmlTransient
    public List<FriendRequest> getFriendRequestList() {
        return friendRequestList;
    }

    public void setFriendRequestList(List<FriendRequest> friendRequestList) {
        this.friendRequestList = friendRequestList;
    }

    @XmlTransient
    public List<FriendRequest> getFriendRequestList1() {
        return friendRequestList1;
    }

    public void setFriendRequestList1(List<FriendRequest> friendRequestList1) {
        this.friendRequestList1 = friendRequestList1;
    }

    @XmlTransient
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @XmlTransient
    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @XmlTransient
    public List<PageFan> getPageFanList() {
        return pageFanList;
    }

    public void setPageFanList(List<PageFan> pageFanList) {
        this.pageFanList = pageFanList;
    }

    @XmlTransient
    public List<Group1> getGroup1List() {
        return group1List;
    }

    public void setGroup1List(List<Group1> group1List) {
        this.group1List = group1List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.UserProfile[ userId=" + userId + " ]";
    }
    
}
