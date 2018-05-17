/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Theme;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import models.ThemeFacade;

/**
 *
 * @author salmen.sf
 */
@Named(value = "themeController")
@SessionScoped
public class ThemeController implements Serializable {

    @EJB
    private ThemeFacade themeFacade;
    private Theme theme = new Theme();

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
    
    public ThemeController() {
    }
    
    public List<Theme> getAll(){
        return themeFacade.findAll();
    }
    
    public void delete(Theme theme){
        this.themeFacade.remove(theme);
    }
    
    public String add(){
        themeFacade.create(this.theme);
        return "index";
    }
    
    public String edit(Theme theme){
        System.out.println("editFunction");
        this.theme = theme;
        return "edit";
    }
    
    public String update(){
        themeFacade.edit(this.theme);
        return "index";
    }
}