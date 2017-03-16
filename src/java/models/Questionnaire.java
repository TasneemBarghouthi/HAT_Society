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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tasneem
 */
@Entity
@Table(name = "questionnaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionnaire.findAll", query = "SELECT q FROM Questionnaire q")
    , @NamedQuery(name = "Questionnaire.findByQuestionnaireId", query = "SELECT q FROM Questionnaire q WHERE q.questionnaireId = :questionnaireId")
    , @NamedQuery(name = "Questionnaire.findByName", query = "SELECT q FROM Questionnaire q WHERE q.name = :name")
    , @NamedQuery(name = "Questionnaire.findByUrl", query = "SELECT q FROM Questionnaire q WHERE q.url = :url")
    , @NamedQuery(name = "Questionnaire.findByPublishedDate", query = "SELECT q FROM Questionnaire q WHERE q.publishedDate = :publishedDate")})
public class Questionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "questionnaire_id")
    private Integer questionnaireId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Column(name = "published_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserProfile userId;

    public Questionnaire() {
    }

    public Questionnaire(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Questionnaire(Integer questionnaireId, String name, String url, Date publishedDate) {
        this.questionnaireId = questionnaireId;
        this.name = name;
        this.url = url;
        this.publishedDate = publishedDate;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public UserProfile getUserId() {
        return userId;
    }

    public void setUserId(UserProfile userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionnaireId != null ? questionnaireId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionnaire)) {
            return false;
        }
        Questionnaire other = (Questionnaire) object;
        if ((this.questionnaireId == null && other.questionnaireId != null) || (this.questionnaireId != null && !this.questionnaireId.equals(other.questionnaireId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Questionnaire[ questionnaireId=" + questionnaireId + " ]";
    }
    
}
