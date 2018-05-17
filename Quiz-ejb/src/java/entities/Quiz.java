/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author Salmen
 */
@Entity
@Table(name = "quiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q")
    , @NamedQuery(name = "Quiz.findById", query = "SELECT q FROM Quiz q WHERE q.id = :id")
    , @NamedQuery(name = "Quiz.findBySujet", query = "SELECT q FROM Quiz q WHERE q.sujet = :sujet")
    , @NamedQuery(name = "Quiz.findByDur\u00e9e", query = "SELECT q FROM Quiz q WHERE q.dur\u00e9e = :dur\u00e9e")
    , @NamedQuery(name = "Quiz.findByDate", query = "SELECT q FROM Quiz q WHERE q.date = :date")
    , @NamedQuery(name = "Quiz.findByMeilleurScore", query = "SELECT q FROM Quiz q WHERE q.meilleurScore = :meilleurScore")
    , @NamedQuery(name = "Quiz.findByEnseignant", query = "SELECT q FROM Quiz q WHERE q.enseignant = :enseignant")
    , @NamedQuery(name = "Quiz.findByActive", query = "SELECT q FROM Quiz q WHERE q.active = :active")})
public class Quiz implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "meilleur_score")
    private float meilleurScore;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sujet")
    private String sujet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dur\u00e9e")
    private String durée;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 45)
    @Column(name = "enseignant")
    private String enseignant;
    @Column(name = "active")
    private Integer active;
    @JoinColumn(name = "id_theme", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Theme idTheme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuiz")
    private List<Question> questionList;

    public Quiz() {
    }

    public Quiz(Integer id) {
        this.id = id;
    }

    public Quiz(Integer id, String sujet, String durée, Date date, int meilleurScore) {
        this.id = id;
        this.sujet = sujet;
        this.durée = durée;
        this.date = date;
        this.meilleurScore = meilleurScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDurée() {
        return durée;
    }

    public void setDurée(String durée) {
        this.durée = durée;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMeilleurScore() {
        return meilleurScore;
    }

    public void setMeilleurScore(float meilleurScore) {
        this.meilleurScore = meilleurScore;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Theme getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Theme idTheme) {
        this.idTheme = idTheme;
    }

    @XmlTransient
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
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
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Quiz[ id=" + id + " ]";
    }
    
}
