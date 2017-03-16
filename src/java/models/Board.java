/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tasneem
 */
@Entity
@Table(name = "board")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Board.findAll", query = "SELECT b FROM Board b")
    , @NamedQuery(name = "Board.findByBoardId", query = "SELECT b FROM Board b WHERE b.boardId = :boardId")})
public class Board implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "board_id")
    private Integer boardId;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    @ManyToOne(optional = false)
    private Course courseId;
    @JoinColumn(name = "msg_id", referencedColumnName = "msg_id")
    @ManyToOne(optional = false)
    private Msg msgId;

    public Board() {
    }

    public Board(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    public Msg getMsgId() {
        return msgId;
    }

    public void setMsgId(Msg msgId) {
        this.msgId = msgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (boardId != null ? boardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Board)) {
            return false;
        }
        Board other = (Board) object;
        if ((this.boardId == null && other.boardId != null) || (this.boardId != null && !this.boardId.equals(other.boardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Board[ boardId=" + boardId + " ]";
    }
    
}
