package store.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import store.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilisateurDAO {
    
    public Utilisateur verifierLoginMdp(String log, String mdp) throws RuntimeException {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:monlog AND u.motDePasse=:monmdp");
        query.setParameter("monlog", log);
        query.setParameter("monmdp", mdp);
        
        return (Utilisateur) query.getSingleResult();
    }
    
    public List<Utilisateur> rechercherLogin(String log) throws RuntimeException {
        
        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();

        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:monlog ");
        query.setParameter("monlog", log);
        
        return query.getResultList();
    }
    
    public void ajouterUtilisateur(Utilisateur u) throws RuntimeException {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        em.getTransaction().begin();
        
        em.persist(u);

        em.getTransaction().commit();
    }
    
}
