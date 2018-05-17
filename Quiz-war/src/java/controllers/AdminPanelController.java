package controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sjamel
 */
@Named(value = "adminPanelController")
@SessionScoped
public class AdminPanelController implements Serializable{
    
    
    
    public String redirect(String path){
        return path + "/index.xhtml?faces_redirect=true";
        
    }
    
}
