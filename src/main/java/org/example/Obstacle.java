package org.example;

public class Obstacle {
    private Forme forme;

    public Obstacle(Forme forme) {
        this.forme = forme;
    }

    public Forme getForme() {
        return forme;
    }

    @Override
    public String toString() {
        return "Obstacle de forme : " + forme;
    }
}
