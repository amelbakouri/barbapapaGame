package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jeu {
    // Liste de formes prédéfinies
    private List<Forme> formes;
    private List<Obstacle> obstacles;
    private Barbapapa barbapapa;
    private Scanner scanner;

    public Jeu() {
        formes = new ArrayList<>();
        obstacles = new ArrayList<>();
        barbapapa = new Barbapapa();  // Initialisation de Barbapapa
        scanner = new Scanner(System.in);
        initialiserFormes();  // Initialiser les formes
        genererObstacles();
    }

    // Méthode pour initialiser les formes
    private void initialiserFormes() {
        formes.add(new Forme("Cercle"));
        formes.add(new Forme("Carré"));
        formes.add(new Forme("Triangle"));
    }

    private void genererObstacles() {
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            Forme formeAleatoire = formes.get(random.nextInt(formes.size()));
            obstacles.add(new Obstacle(formeAleatoire));
        }
    }

    // Méthode pour choisir un obstacle aléatoire
    private Obstacle choisirObstacleAleatoire() {
        Random random = new Random();
        int index = random.nextInt(obstacles.size());
        return obstacles.get(index);
    }

    // Méthode pour lire les choix utilisateur
    private int lireChoixUtilisateur() {
        int choix;
        System.out.print("Choisissez une forme pour Barbapapa : ");
        choix = scanner.nextInt();  // Lecture de l'entrée utilisateur
        return choix;
    }

    private boolean verifierObstacle(Forme formeChoisie){
        for (Obstacle obstacle : obstacles){
            if (obstacle.getForme().equals(formeChoisie)){
                return true; // Barbapapa a franchi l'obstacle
            }
        }
        return false; // Barbapapa n'a pas réussi à franchir l'obstacle
    }


    // Méthode principale du jeu
    public void lancerPartie() {
        boolean jeuEnCours = true;

        while (jeuEnCours) {
            // Afficher un obstacle aléatoire pour ce tour
            Obstacle obstacleActuel = choisirObstacleAleatoire();
            System.out.println("Obstacle à surmonter: " + obstacleActuel);

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

                if (verifierObstacle(formeChoisie)){
                    System.out.println("Bravo ! Vous avez franchi l'obstacle.");
                } else {
                    System.out.println("Obstacle non franchi, essayer à nouveau.");
                }
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
