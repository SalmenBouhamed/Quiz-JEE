/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Choix;
import entities.Question;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.ChoixFacade;
import models.QuestionFacade;

/**
 *
 * @author sjamel
 */
@Named(value = "choixController")
@SessionScoped
public class ChoixController implements Serializable{
    
    @EJB
    private ChoixFacade choixFacade;
    @EJB
    private QuestionFacade questionFacade;
    
    private Choix choix = new Choix();
    private Question question = new Question();
    
    private int questionId;
    
    /**
     * Creates a new instance of ThemeController
     */
    
    public ChoixController() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Choix getChoix() {
        return choix;
    }

    public void setChoix(Choix choix) {
        this.choix = choix;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
   
    
    public List<Choix> getAll(){
        return choixFacade.findAll();
    }
    
    public void delete(Choix choix){
        this.choixFacade.remove(choix);
    }
    
    public String add(){
     
        this.choix.setIdQuestion((Question) questionFacade.findById(questionId));
        choixFacade.create(this.choix);
        return "index";
        
    }
    
    public String edit(Choix choix){
        this.choix = choix;
        return "edit";
    }
    
    public String update(){
        choixFacade.edit(this.choix);
        return "index";
    }
    
}
