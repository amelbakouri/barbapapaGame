package org.example;

public class Barbapapa {
    private Forme formeActuelle;

    public Barbapapa() {
        // Par défaut, Barbapapa a une forme initiale
        this.formeActuelle = new Forme("barbapapa");
    }

    public void changerForme(Forme nouvelleForme) {
        this.formeActuelle = nouvelleForme;
        System.out.println("Barbapapa s'est transformé en : " + nouvelleForme);
    }

    public Forme getFormeActuelle() {
        return formeActuelle;
    }
}
