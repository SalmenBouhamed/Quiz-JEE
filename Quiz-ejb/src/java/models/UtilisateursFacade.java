/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Utilisateurs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Salmen
 */
@Stateless
public class UtilisateursFacade extends AbstractFacade<Utilisateurs> {

    @PersistenceContext(unitName = "Quiz-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateursFacade() {
        super(Utilisateurs.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<Utilisateurs> findByUsernameAndPwd(String username, String pwd) {

        return (List<Utilisateurs>) em.createQuery("SELECT u FROM Utilisateurs u WHERE u.username = :username AND u.password = :password")
                .setParameter("username", username)
                .setParameter("password", pwd)
                .getResultList();
        
    }
}
