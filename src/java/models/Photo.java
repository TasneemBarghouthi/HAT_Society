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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tasneem
 */
@Entity
@Table(name = "photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p")
    , @NamedQuery(name = "Photo.findByPhotosId", query = "SELECT p FROM Photo p WHERE p.photosId = :photosId")
    , @NamedQuery(name = "Photo.findByDate", query = "SELECT p FROM Photo p WHERE p.date = :date")})
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "photos_id")
    private Integer photosId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "picture_url")
    private String pictureUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;

    public Photo() {
    }

    public Photo(Integer photosId) {
        this.photosId = photosId;
    }

    public Photo(Integer photosId, String pictureUrl, Date date, String description) {
        this.photosId = photosId;
        this.pictureUrl = pictureUrl;
        this.date = date;
        this.description = description;
    }

    public Integer getPhotosId() {
        return photosId;
    }

    public void setPhotosId(Integer photosId) {
        this.photosId = photosId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (photosId != null ? photosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Photo)) {
            return false;
        }
        Photo other = (Photo) object;
        if ((this.photosId == null && other.photosId != null) || (this.photosId != null && !this.photosId.equals(other.photosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Photo[ photosId=" + photosId + " ]";
    }
    
}
