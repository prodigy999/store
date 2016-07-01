/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import store.entity.Article;
import store.entity.Commande;
import store.service.CommandeService;

/**
 *
 * @author admin
 */
@WebServlet(name = "PanierServlet", urlPatterns = {"/panier"})
public class PanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        Commande commandeUtilLogger = (Commande)req.getSession().getAttribute("commandeUtilisateur");
        List <Article> panier = commandeUtilLogger.getArticles();
        
        req.setAttribute("total", req.getSession().getAttribute("total"));
        
        req.setAttribute("articles", panier);
        
        req.getRequestDispatcher("panier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Date date = new Date();
        Commande commandeUtilLogger = (Commande)req.getSession().getAttribute("commandeUtilisateur");
        
        commandeUtilLogger.setDateCommande(date);
        commandeUtilLogger.setEtat(Commande.Etat.VALIDE);
        
        new CommandeService().ajouterCommande(commandeUtilLogger);
                
        resp.sendRedirect("payer_commande");
        
    }
    
    
}
