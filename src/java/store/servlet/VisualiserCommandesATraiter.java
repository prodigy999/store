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
import store.entity.Commande;
import store.service.CommandeService;

/**
 *
 * @author admin
 */
@WebServlet(name = "VisualiserCommandes", urlPatterns = {"/commandeATraite"})
public class VisualiserCommandesATraiter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Commande> listeCommande = new CommandeService().listerCommandesTrieParDateEtatFinalise();
        req.setAttribute("commandes", listeCommande);
        
        
        
        req.getRequestDispatcher("commande_a_traiter.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long idCommande = (long)req.getAttribute("idCommande");
        
        Commande commandeUtilLogger = new CommandeService().rechercheParID(idCommande);
        commandeUtilLogger.setEtat(Commande.Etat.EXPEDIE);
        new CommandeService().modifierCommande(commandeUtilLogger);
        
                
        resp.sendRedirect("commandesExpedie");
        
    }

}
