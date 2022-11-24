package be.ieps.poo.arnaud;

import java.util.HashMap;


public class ControllerJeu {

    private HashMap<String, Joueur> listeJoueurs;
    int nbJoueur;

    public void initialisationJoueur() {

        listeJoueurs = new HashMap<>();

        listeJoueurs.put("Joueur 1", new Joueur("Arnaud", this));
        listeJoueurs.put("Joueur 2", new Joueur("Corentin", this));
        listeJoueurs.put("Joueur 3", new Joueur("Julien", this));
        listeJoueurs.put("Joueur 4", new Joueur("Pol",  this));
        listeJoueurs.put("Joueur 5", new Joueur("Marie",  this));
        listeJoueurs.put("Joueur 6", new Joueur("Gauthier",  this));
        listeJoueurs.put("Joueur 7", new Joueur("Arnaud", this));
    }


    public HashMap<String, Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(HashMap<String, Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public void nbJoueurAleatoire() {
        nbJoueur = (int) (Math.random() * (listeJoueurs.size() - 4)) + 4;
        for (int i = 1; i < nbJoueur + 1; i++) {
            listeJoueurs.get("Joueur " +i).start();
        }
    }

    public void startClassementDaemon() {
        ClassementDaemon classementDaemon = new ClassementDaemon(this);

        classementDaemon.setDaemon(true);
        classementDaemon.start();
    }


}

