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
import store.entity.Article;

/**
 *
 * @author admin
 */
public class ArticleDAO {

    public List<Article> listerArticlesTrieParNom() {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        return em.createQuery("SELECT a FROM Article a ORDER BY a.nom").getResultList();
    }

    public Article rechercheParID(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        return em.find(Article.class, id);
    }
    
    public void modifierArticle(Article a) {

        EntityManager em = Persistence.createEntityManagerFactory("StorePU").createEntityManager();
        em.getTransaction().begin();

        em.merge(a);

        em.getTransaction().commit();
    }
    
    
}
