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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "page_fan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PageFan.findAll", query = "SELECT p FROM PageFan p")
    , @NamedQuery(name = "PageFan.findByPageId", query = "SELECT p FROM PageFan p WHERE p.pageId = :pageId")
    , @NamedQuery(name = "PageFan.findByLikeDate", query = "SELECT p FROM PageFan p WHERE p.likeDate = :likeDate")})
public class PageFan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "page_id")
    private Integer pageId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "like_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date likeDate;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserProfile userId;
    @JoinColumn(name = "page_id", referencedColumnName = "page_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Page page;

    public PageFan() {
    }

    public PageFan(Integer pageId) {
        this.pageId = pageId;
    }

    public PageFan(Integer pageId, Date likeDate) {
        this.pageId = pageId;
        this.likeDate = likeDate;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Date getLikeDate() {
        return likeDate;
    }

    public void setLikeDate(Date likeDate) {
        this.likeDate = likeDate;
    }

    public UserProfile getUserId() {
        return userId;
    }

    public void setUserId(UserProfile userId) {
        this.userId = userId;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pageId != null ? pageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PageFan)) {
            return false;
        }
        PageFan other = (PageFan) object;
        if ((this.pageId == null && other.pageId != null) || (this.pageId != null && !this.pageId.equals(other.pageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.PageFan[ pageId=" + pageId + " ]";
    }
    
}
