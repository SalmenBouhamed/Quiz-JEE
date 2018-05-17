/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Theme;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Salmen
 */
@Stateless
public class ThemeFacade extends AbstractFacade<Theme> {

    @PersistenceContext(unitName = "Quiz-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ThemeFacade() {
        super(Theme.class);
    }
    
    @SuppressWarnings("unchecked")
    public Theme findById(int id) throws NoResultException{
            return (Theme) em.createQuery("SELECT t FROM Theme t WHERE t.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        
    }
}
