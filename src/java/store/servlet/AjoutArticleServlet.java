/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import store.entity.Article;
import store.service.ArticleService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutArticleServlet", urlPatterns = {"/ajout_article"})
public class AjoutArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("ajout_article.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Article article = new Article ();
        
        article.setNom(req.getParameter("nom"));
        article.setStock((Long.parseLong(req.getParameter("stock"))));
        article.setPrix((Long.parseLong(req.getParameter("prix"))));
        
        new ArticleService().ajouterArticle(article);
        
        resp.sendRedirect("liste_articles");
    }

}
