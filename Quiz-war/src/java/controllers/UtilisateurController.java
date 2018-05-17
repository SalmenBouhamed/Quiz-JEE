/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Theme;
import entities.Utilisateurs;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import models.ThemeFacade;
import models.UtilisateursFacade;

/**
 *
 * @author salmen.sf
 */
@Named(value = "utilisateurController")
@SessionScoped
public class UtilisateurController implements Serializable {

    @EJB
    private UtilisateursFacade utilisateursFacade;

    private Utilisateurs utilisateur = new Utilisateurs();

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    public UtilisateurController() {
    }
    
    public List<Utilisateurs> getAll(){
        return utilisateursFacade.findAll();
    }
    
    public void delete(Utilisateurs utilisateur){
        this.utilisateursFacade.remove(utilisateur);
    }
    
    public String add(){
        utilisateursFacade.create(this.utilisateur);
        return "index";
    }
    
    public String edit(Utilisateurs utilisateur){
        this.utilisateur = utilisateur;
        return "edit";
    }
    
    public String update(){
        utilisateursFacade.edit(this.utilisateur);
        return "index";
    }
}