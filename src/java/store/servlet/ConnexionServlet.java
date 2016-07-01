/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import store.entity.Article;
import store.entity.Commande;
import store.entity.Utilisateur;
import store.service.UtilisateurService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/login"})
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().removeAttribute("UtilConnecte");
        req.getSession().removeAttribute("nombreArticles");
        req.getSession().removeAttribute("commandeUtilisateur");
        req.getSession().removeAttribute("total");
        
        try {
            String log = req.getParameter("login");
            String mdp = req.getParameter("motDePasse");
            Utilisateur u = new UtilisateurService().verifierLoginMdp(log, mdp);
            
            req.getSession().setAttribute("UtilConnecte", u);
            Commande commandeUtilLogger = new Commande();
            List <Article> panier = new ArrayList<>();
            commandeUtilLogger.setArticles(panier);
            commandeUtilLogger.setUtilisateur(u);
            req.getSession().setAttribute("commandeUtilisateur", commandeUtilLogger);
            req.getSession().setAttribute("nombreArticles", (long)0);
            req.getSession().setAttribute("total", (long)0);
           
            resp.sendRedirect("liste_articles");
        } 
        
        catch (RuntimeException e) {
            
            resp.sendRedirect("inscription");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("connexion.jsp").forward(req, resp);

    }

}
