/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salmen
 */
@Entity
@Table(name = "choix")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Choix.findAll", query = "SELECT c FROM Choix c")
    , @NamedQuery(name = "Choix.findById", query = "SELECT c FROM Choix c WHERE c.id = :id")
    , @NamedQuery(name = "Choix.findByReponse", query = "SELECT c FROM Choix c WHERE c.reponse = :reponse")
    , @NamedQuery(name = "Choix.findByType", query = "SELECT c FROM Choix c WHERE c.type = :type")})
public class Choix implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "reponse")
    private String reponse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "id_question", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Question idQuestion;

    public Choix() {
    }

    public Choix(Integer id) {
        this.id = id;
    }

    public Choix(Integer id, String reponse, String type) {
        this.id = id;
        this.reponse = reponse;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Question getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Question idQuestion) {
        this.idQuestion = idQuestion;
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
        if (!(object instanceof Choix)) {
            return false;
        }
        Choix other = (Choix) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Choix[ id=" + id + " ]";
    }
    
}
