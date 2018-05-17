/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Question;
import entities.Quiz;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sjamel
 */
@Stateless
public class QuestionFacade extends AbstractFacade<Question> {

    @PersistenceContext(unitName = "Quiz-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuestionFacade() {
        super(Question.class);
    }
    
     @SuppressWarnings("unchecked")
    public Question findById(int id) throws NoResultException{
            return (Question) em.createQuery("SELECT q FROM Question q WHERE q.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        
    }
    
}
