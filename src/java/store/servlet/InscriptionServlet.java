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
import store.entity.Utilisateur;
import store.entity.Utilisateur.TypeUtil;
import store.service.UtilisateurService;


/**
 *
 * @author admin
 */
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String log = req.getParameter("login");
        String mdp = req.getParameter("motDePasse");
        String mdp2 = req.getParameter("motDePasse2");
        String adresse = req.getParameter("adresse");
        String type = req.getParameter("type");

        if (!mdp.equals(mdp2)) {

            resp.sendRedirect("inscription");
            return;
        }

        Utilisateur u = new Utilisateur();
        u.setLogin(log);
        u.setMotDePasse(mdp);
        u.setAdresse(adresse);
        u.setTypeUtil(TypeUtil.valueOf(type));
        new UtilisateurService().ajouterUtilisateur(u);
        
        req.getSession().setAttribute("UtilConnecte", u);
        
        resp.sendRedirect("liste_articles");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("inscription.jsp").forward(req, resp);
    }

}
