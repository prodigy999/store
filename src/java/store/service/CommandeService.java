/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.service;

import java.util.List;
import store.dao.CommandeDAO;
import store.entity.Commande;

/**
 *
 * @author admin
 */
public class CommandeService {

    public void ajouterCommande(Commande c) {

        new CommandeDAO().modifierCommande(c);
    }
    
    public void modifierCommande(Commande c) {

        new CommandeDAO().modifierCommande(c);
    }
    
    public List<Commande> listerCommandesTrieParDateEtatFinalise() {

        CommandeDAO dao = new CommandeDAO();
        return dao.listerCommandesTrieParDateEtatFinalise();
    }
    
    public List<Commande> listerCommandesTrieParDateEtatExpedie() {

        CommandeDAO dao = new CommandeDAO();
        return dao.listerCommandesTrieParDateEtatExpedie();
    }
    
    public Commande rechercheParID(long id) {

        CommandeDAO dao = new CommandeDAO();
        return dao.rechercheParID(id);
    }

}
