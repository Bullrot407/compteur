package be.ieps.poo.arnaud;


public class App {
    public static void main(String[] args) {
        ControllerJeu contJeu = new ControllerJeu();

        contJeu.initialisationJoueur();
        contJeu.nbJoueurAleatoire();
        contJeu.startClassementDaemon();
    }
}