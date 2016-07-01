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
@WebServlet(name = "AjoutStockArticleServlet", urlPatterns = {"/ajout_stock"})
public class AjoutStockArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("ajout_stock.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long idArticle = Long.parseLong(req.getParameter("idArticle"));
        Article article = new ArticleService().rechercheParID(idArticle);
        
        article.setStock(article.getStock() + (Long.parseLong(req.getParameter("quantiteStock"))));
        
        new ArticleService().modifierArticle(article);
        
        resp.sendRedirect("liste_articles");
    }

    
}
