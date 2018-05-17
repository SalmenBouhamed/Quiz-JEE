/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Quiz;
import entities.Theme;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.QuizFacade;
import models.ThemeFacade;

/**
 *
 * @author sjamel
 */
@Named(value = "quizController")
@SessionScoped
public class QuizController implements Serializable{
    
    @EJB
    private QuizFacade quizFacade;
    @EJB
    private ThemeFacade themeFacade;
    
    private Quiz quiz = new Quiz();
    private Theme t = new Theme();
    
    private int themeId;
    
     /**
     * Creates a new instance of ThemeController
     */
    
    public QuizController() {
    }
    

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    public List<Quiz> getAll(){
        return quizFacade.findAll();
    }

    
    public void delete(Quiz quiz){
        this.quizFacade.remove(quiz);
    }
    
    public String add(){
     
        this.quiz.setIdTheme((Theme) themeFacade.findById(themeId));
        quizFacade.create(this.quiz);
        return "index";
        
    }
    
    public String edit(Quiz quiz){
        this.quiz = quiz;
        return "edit";
    }
    
    public String update(){
        quizFacade.edit(this.quiz);
        return "index";
    }
    
    public String takeTheQuiz(Quiz quiz){
        this.quiz = quiz;
        return "quiz";
    }
}
