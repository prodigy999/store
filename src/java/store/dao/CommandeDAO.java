/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import store.entity.Commande;

/**
 *
 * @author admin
 */
public class CommandeDAO {

    public void modifierCommande(Commande c) {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        em.getTransaction().begin();

        em.merge(c);

        em.getTransaction().commit();
    }
    
    public List<Commande> listerCommandesTrieParDateEtatFinalise() {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        Query query = em.createQuery("SELECT c FROM Commande c WHERE c.etat=:monetat ORDER BY c.dateCommande");
        query.setParameter("monetat", Commande.Etat.FINALISE);
        return query.getResultList();
    }
    
    public List<Commande> listerCommandesTrieParDateEtatExpedie() {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        Query query = em.createQuery("SELECT c FROM Commande c WHERE c.etat=:monetat ORDER BY c.dateCommande");
        query.setParameter("monetat", Commande.Etat.EXPEDIE);
        return query.getResultList();
    }
    
    public Commande rechercheParID(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        return em.find(Commande.class, id);
    }

}
