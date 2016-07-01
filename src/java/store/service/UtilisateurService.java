package store.service;

import java.util.List;
import store.dao.UtilisateurDAO;
import store.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilisateurService {
    
    public Utilisateur verifierLoginMdp(String log, String mdp) throws RuntimeException {
        
        return new UtilisateurDAO().verifierLoginMdp(log, mdp);
    }
    
    public void ajouterUtilisateur (Utilisateur u) throws RuntimeException {
        
        UtilisateurDAO  dao = new UtilisateurDAO();
        
        List<Utilisateur> listLogExist = dao.rechercherLogin(u.getLogin());
        
        if (listLogExist.size()>0){
            throw new RuntimeException ("Ce login existe déjà");
        }
        
        dao.ajouterUtilisateur(u);
    }
}
