package fr.ecole3il.rodez2023.carte;

import java.util.ArrayList;
import java.util.List;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Chemin;

public class AdaptateurAlgorithme {
    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee){
        Graphe<Case> graphe = creerGraphe(carte);
        Case depart = carte.getCase(xDepart, yDepart);
        Case arrivee = carte.getCase(xArrivee, yArrivee);

        List<Noeud<Case>> chemin = algorithme.trouverChemin(graphe, depart, arrivee);
        List<Case> CaseChemin = new ArrayList<>();
        for (Noeud<Case> noeud : chemin){
            CaseChemin.add(noeud.getValeur());
        }
        return new Chemin(chemin);
    }
    public static Graphe <Case> creerGraphe(Carte carte){
        Graphe<Case> graphe = new Graphe<Case>();
        return graphe;
    }
    public static void ajouterAretesVoisines(Graphe<Case> graphe, Case currentCase, int x, int y, int largeur, int hauteur) {
    }
    public static double calculerCout(Case from, Case to){
        double coutcalcule =0.0;

        return coutcalcule;
    }
    /*public static afficherChemin(List<Noeud<Case>> chemin){

    } */
}

