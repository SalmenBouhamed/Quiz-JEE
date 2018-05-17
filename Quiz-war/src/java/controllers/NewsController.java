/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.News;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import models.NewsFacade;

/**
 *
 * @author Salmen
 */
@Named(value = "newsController")
@SessionScoped
public class NewsController implements Serializable {

    @EJB
    private NewsFacade newsFacade;
    
    

    /**
     * Creates a new instance of NewsController
     */
    public NewsController() {
    }
    
    
    public List<News> getALL(){
        return newsFacade.findAll();
    }
}
