package be.ieps.poo.arnaud;

public class Joueur extends Thread {

    int NB_TOURMAX = 10;
    private String prenom;
    private int nbTour;
    private long tempsTotal;
    private Boolean statutThread;
    private long attente;

    ControllerJeu contJeu;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNbTour() {
        return nbTour;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public long getTempsTotal() {
        return tempsTotal;
    }

    public void setTempsTotal(long tempsTotal) {
        this.tempsTotal = tempsTotal;
    }

    public Boolean getStatutThread() {
        return statutThread;
    }

    public void setStatutThread(Boolean statutThread) {
        this.statutThread = statutThread;
    }


    public long getAttente() {
        return attente;
    }




    public Joueur(String prenom, ControllerJeu contJeu) {

        this.prenom = prenom;
        this.nbTour = 0;
        this.tempsTotal = 0;
        this.statutThread = true;
        this.attente = 0;
        this.contJeu = contJeu;
    }

    @Override
    public String toString() {
        return "Le joueur " + prenom + " a fait le " + nbTour + " en " + attente + " ms, pour un total de " + tempsTotal + " sont etat dans la course est (" + statutThread + ')';
    }

    public long tempsTours() {
        long tempsTours = (int) (Math.random() * 5000);
        return tempsTours;
    }


    public void run() {
        try {
            while (statutThread) {
                this.nbTour++;
                this.attente = tempsTours();

                this.tempsTotal += attente;
                System.out.println(this.toString());
                if (this.nbTour >= NB_TOURMAX) {
                    this.statutThread = false;
                }
                if (this.nbTour == NB_TOURMAX) {
                    System.out.println("******************************************");
                    System.out.println("Le joueur " + this.prenom + " a fini en " + this.tempsTotal + " ms !!!");
                    System.out.println("******************************************");
                }
                // Rem: sleep oblige la gestion de l'erreur d'interruption
                sleep(attente);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread calc arrêté");
        }
    }


}

