/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.service;

import java.util.List;
import store.dao.ArticleDAO;
import store.entity.Article;

/**
 *
 * @author admin
 */
public class ArticleService {

    public List<Article> listerArticlesTrieParNom() {

        ArticleDAO dao = new ArticleDAO();
        return dao.listerArticlesTrieParNom();
    }

    public Article rechercheParID(long id) {

        ArticleDAO dao = new ArticleDAO();
        return dao.rechercheParID(id);
    }
    
    public void modifierArticle(Article a) {
        
        new ArticleDAO().modifierArticle(a);
    }
    
    public void ajouterArticle(Article a) {
        
        new ArticleDAO().modifierArticle(a);
    }
    
    
}
