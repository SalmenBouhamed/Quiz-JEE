/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
public class QuizFacade extends AbstractFacade<Quiz> {

    @PersistenceContext(unitName = "Quiz-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public QuizFacade() {
        super(Quiz.class);
    }
    
    @SuppressWarnings("unchecked")
    public Quiz findById(int id) throws NoResultException{
            return (Quiz) em.createQuery("SELECT q FROM Quiz q WHERE q.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        
    }
    
    
}
