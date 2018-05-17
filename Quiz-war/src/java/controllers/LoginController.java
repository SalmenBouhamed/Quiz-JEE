/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Utilisateurs;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import models.UtilisateursFacade;

/**
 *
 * @author sjamel
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    @EJB
    private UtilisateursFacade utilisateursFacade;
    
    
    private Utilisateurs userConnected;
    private String username;
    private String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Utilisateurs getUserConnected() {
        return userConnected;
    }

    public void setUserConnected(Utilisateurs userConnected) {
        this.userConnected = userConnected;
    }
    
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
    
    public String login(){
        
        try{
            Utilisateurs user = utilisateursFacade.findByUsernameAndPwd(username, pwd).get(0);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("userSession", user);
            userConnected = user;
            
            if(user.getRole().equals("ADMIN")){
                return "themes/index.xhtml?faces_redirect=true";
            }
            else
            return "index.xhtml?faces_redirect=true";
	
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
            return "login.xhtml?faces_redirect=true";
        }  
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index";
    }
    
    public String updateProfile(){
        utilisateursFacade.edit(userConnected);
        return "index";
    }
}
