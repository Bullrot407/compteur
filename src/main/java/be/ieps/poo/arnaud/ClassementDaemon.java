package be.ieps.poo.arnaud;

import java.util.ArrayList;

public class ClassementDaemon extends Thread {
    private ControllerJeu contJeu;
    private Joueur joueur;

    public ClassementDaemon(ControllerJeu classement) {
        this.contJeu = classement;
    }


    public void classement() {
        ArrayList<Joueur> classementGen = new ArrayList<Joueur>();
        for (int i = 1; i <= contJeu.nbJoueur; i++) {
            classementGen.add(contJeu.getListeJoueurs().get("Joueur " + String.valueOf(i)));
        }
        for (int i = 0; i < classementGen.size(); i++) {
            for (int j = i + 1; j < classementGen.size(); j++) {
                if (classementGen.get(i).getTempsTotal() > classementGen.get(j).getTempsTotal()) {
                    Joueur temp = classementGen.get(i);
                    classementGen.set(i, classementGen.get(j));
                    classementGen.set(j, temp);
                }
            }
        }
        System.out.println("\n**********************************************");
        for (int j = 0, place = 1; j < classementGen.size(); j++, place++) {
            Joueur joueur = classementGen.get(j);

            System.out.println(joueur.getPrenom() + "a terminé la course en " + place + " en " + joueur.getTempsTotal() + "ms !!!");
        }
        System.out.println("\n**********************************************");
    }

    public void controleStatutThreadTousFalse() {
        //verifie que tous les Thread's soient FALSE
        for (int i = 1; i <= contJeu.nbJoueur; i++) {
            while (contJeu.getListeJoueurs().get("Joueur " + String.valueOf(i)).getStatutThread() == true) {
            }
        }
        classement();

    }

    @Override
    public void run() {
        controleStatutThreadTousFalse();
    }
}
