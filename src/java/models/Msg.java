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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "msg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Msg.findAll", query = "SELECT m FROM Msg m")
    , @NamedQuery(name = "Msg.findByMsgId", query = "SELECT m FROM Msg m WHERE m.msgId = :msgId")
    , @NamedQuery(name = "Msg.findBySendTime", query = "SELECT m FROM Msg m WHERE m.sendTime = :sendTime")})
public class Msg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "msg_id")
    private Integer msgId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "send_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;
    @Lob
    @Size(max = 16777215)
    @Column(name = "file")
    private String file;
    @Lob
    @Size(max = 16777215)
    @Column(name = "video")
    private String video;
    @Lob
    @Size(max = 16777215)
    @Column(name = "picture")
    private String picture;
    @JoinTable(name = "msg_reciever", joinColumns = {
        @JoinColumn(name = "msg_id", referencedColumnName = "msg_id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")})
    @ManyToMany
    private List<UserProfile> userProfileList;
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserProfile senderId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "msgId")
    private List<Board> boardList;

    public Msg() {
    }

    public Msg(Integer msgId) {
        this.msgId = msgId;
    }

    public Msg(Integer msgId, String content, Date sendTime) {
        this.msgId = msgId;
        this.content = content;
        this.sendTime = sendTime;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @XmlTransient
    public List<UserProfile> getUserProfileList() {
        return userProfileList;
    }

    public void setUserProfileList(List<UserProfile> userProfileList) {
        this.userProfileList = userProfileList;
    }

    public UserProfile getSenderId() {
        return senderId;
    }

    public void setSenderId(UserProfile senderId) {
        this.senderId = senderId;
    }

    @XmlTransient
    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (msgId != null ? msgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Msg)) {
            return false;
        }
        Msg other = (Msg) object;
        if ((this.msgId == null && other.msgId != null) || (this.msgId != null && !this.msgId.equals(other.msgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Msg[ msgId=" + msgId + " ]";
    }
    
}
