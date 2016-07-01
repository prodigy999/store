/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.servlet;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ListerArticlesServlet", urlPatterns = {"/liste_articles"})
public class ListerArticlesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Article> listeArticle = new ArticleService().listerArticlesTrieParNom();
        req.setAttribute("articles", listeArticle);
        req.getRequestDispatcher("liste_articles.jsp").forward(req, resp);
    }
}
