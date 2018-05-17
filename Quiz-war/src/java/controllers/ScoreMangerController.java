/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Choix;
import entities.Question;
import entities.Quiz;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import models.ChoixFacade;
import models.QuizFacade;

/**
 *
 * @author Salmen
 */
@Named(value = "scoreMangerController")
@SessionScoped
public class ScoreMangerController implements Serializable {

    private int quizScore = 0;
    @EJB
    private ChoixFacade choixFacade;
    
    @EJB
    private QuizFacade quizFacade;

    public int getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(int quizScore) {
        this.quizScore = quizScore;
    }
    
    /**
     * Creates a new instance of ScoreMangerController
     */
        
    public ScoreMangerController() {
    }
    
    public String calculeScore(Quiz quiz){
        int score = 0;
        Map<String, String[]> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterValuesMap();
        String[] qList = params.get("question");
        for(String q: qList){
            String[] choixList = params.get("question"+q);
            for(String c: choixList){
                //System.out.println("Question "+q+" : choix :"+c);
                Choix choix = choixFacade.find(Integer.parseInt(c));
                if(choix.getType().equals("VRAI"))
                    score++;
            }
        }
        
        this.quizScore = score;
        
        if(quiz.getMeilleurScore() < score)
        {
            quiz.setMeilleurScore(score);
            quizFacade.edit(quiz);
        }
        
        System.out.println("Le nombre totale est : "+score);
        return "afterQuiz";
    }

}
