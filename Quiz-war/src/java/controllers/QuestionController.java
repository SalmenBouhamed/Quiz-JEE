/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Question;
import entities.Quiz;
import entities.Theme;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.QuestionFacade;
import models.QuizFacade;
import models.ThemeFacade;

/**
 *
 * @author sjamel
 */
@Named(value = "questionController")
@SessionScoped
public class QuestionController implements Serializable{
    
    @EJB
    private QuestionFacade questionFacade;
    @EJB
    private QuizFacade quizFacade;
    
    private Question question = new Question();
    private Quiz quiz = new Quiz();
    
    private int quizId;
    
    /**
     * Creates a new instance of ThemeController
     */
    
    public QuestionController() {
    }
    

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }


    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    
    public List<Question> getAll(){
        return questionFacade.findAll();
    }
    
    public void delete(Question question){
        this.questionFacade.remove(question);
    }
    
    public String add(){
     
        this.question.setIdQuiz((Quiz) quizFacade.findById(quizId));
        questionFacade.create(this.question);
        return "index";
        
    }
    
    public String edit(Question question){
        this.question = question;
        return "edit";
    }
    
    public String update(){
        questionFacade.edit(this.question);
        return "index";
    }
    
}
