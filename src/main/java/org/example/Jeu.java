package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    // Liste de formes prédéfinies
    private List<Forme> formes;
    private Barbapapa barbapapa;
    private Scanner scanner;

    public Jeu() {
        formes = new ArrayList<>();
        barbapapa = new Barbapapa();  // Initialisation de Barbapapa
        scanner = new Scanner(System.in);
        initialiserFormes();  // Initialiser les formes
    }

    // Méthode pour initialiser les formes
    private void initialiserFormes() {
        formes.add(new Forme("Cercle"));
        formes.add(new Forme("Carré"));
        formes.add(new Forme("Triangle"));
    }

    // Méthode pour lire les choix utilisateur
    private int lireChoixUtilisateur() {
        int choix;
        System.out.print("Choisissez une forme pour Barbapapa : ");
        choix = scanner.nextInt();  // Lecture de l'entrée utilisateur
        return choix;
    }

    // Méthode principale du jeu
    public void lancerPartie() {
        boolean jeuEnCours = true;

        while (jeuEnCours) {
            // Afficher les formes disponibles
            System.out.println("Formes disponibles :");
            for (int i = 0; i < formes.size(); i++) {
                System.out.println((i + 1) + " - " + formes.get(i));
            }

            int choixUtilisateur = lireChoixUtilisateur();

            // Vérifier si le choix est valide
            if (choixUtilisateur > 0 && choixUtilisateur <= formes.size()) {
                Forme formeChoisie = formes.get(choixUtilisateur - 1);
                barbapapa.changerForme(formeChoisie);  // Changer la forme de Barbapapa
            } else {
                System.out.println("Choix invalide. Veuillez réessayer.");
                continue;
            }

            System.out.print("Voulez-vous continuer ? (oui/non) : ");
            String reponse = scanner.next();

            if (reponse.equalsIgnoreCase("non")) {
                jeuEnCours = false;  // Terminer le jeu si le joueur ne veut plus
            }
        }

        System.out.println("Merci d'avoir joué !");
        scanner.close();
    }
}
