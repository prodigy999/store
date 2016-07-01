/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ExpedierCommandeServlet", urlPatterns = {"/commandesExpedie"})
public class ExpedierCommandeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Commande> listeCommande = new CommandeService().listerCommandesTrieParDateEtatExpedie();
        
        req.setAttribute("commandes", listeCommande);
        
        req.getRequestDispatcher("commande_expedie.jsp").forward(req, resp);
    }
    
    

}
