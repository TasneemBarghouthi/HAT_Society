/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tasneem
 */
@Entity
@Table(name = "friend_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FriendRequest.findAll", query = "SELECT f FROM FriendRequest f")
    , @NamedQuery(name = "FriendRequest.findById", query = "SELECT f FROM FriendRequest f WHERE f.id = :id")
    , @NamedQuery(name = "FriendRequest.findBySendDate", query = "SELECT f FROM FriendRequest f WHERE f.sendDate = :sendDate")})
public class FriendRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "send_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDate;
    @JoinColumn(name = "reciever_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserProfile recieverId;
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserProfile senderId;

    public FriendRequest() {
    }

    public FriendRequest(Integer id) {
        this.id = id;
    }

    public FriendRequest(Integer id, Date sendDate) {
        this.id = id;
        this.sendDate = sendDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public UserProfile getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(UserProfile recieverId) {
        this.recieverId = recieverId;
    }

    public UserProfile getSenderId() {
        return senderId;
    }

    public void setSenderId(UserProfile senderId) {
        this.senderId = senderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendRequest)) {
            return false;
        }
        FriendRequest other = (FriendRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.FriendRequest[ id=" + id + " ]";
    }
    
}
