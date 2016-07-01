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
import store.entity.Commande;
import store.service.CommandeService;

/**
 *
 * @author admin
 */
@WebServlet(name = "PayerCommandeServlet", urlPatterns = {"/payer_commande"})
public class PayerCommandeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        
        Commande commandeUtilLogger = (Commande)req.getSession().getAttribute("commandeUtilisateur");
        List <Article> panier = commandeUtilLogger.getArticles();
        
        req.setAttribute("total", req.getSession().getAttribute("total"));
        
        req.setAttribute("articles", panier);
        
        req.getRequestDispatcher("facture.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        Commande commandeUtilLogger = (Commande)req.getSession().getAttribute("commandeUtilisateur");
        
        commandeUtilLogger.setEtat(Commande.Etat.FINALISE);
        
        new CommandeService().modifierCommande(commandeUtilLogger);
                
        resp.sendRedirect("login");
        
    }

}
