/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Choix;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Salmen
 */
@Stateless
public class ChoixFacade extends AbstractFacade<Choix> {

    @PersistenceContext(unitName = "Quiz-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChoixFacade() {
        super(Choix.class);
    }
    
}
