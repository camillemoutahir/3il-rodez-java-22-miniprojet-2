package fr.ecole3il.rodez2023.carte;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.*;

import java.util.ArrayList;
import java.util.List;

public class AdaptateurAlgorithme {
    /**
     * Renvoie un chemin entre 2 points sur une carte en utilisant un algorithme de recherche de chemin
     * @param algorithme l'algorithme de recherche de chemin
     * @param carte la carte sur laquelle on cherche le chemin
     * @param xDepart la coordonnée x du point de départ
     * @param yDepart la coordonnée y du point de départ
     * @param xArrivee la coordonnée x du point d'arrivée
     * @param yArrivee la coordonnée y du point d'arrivée
     * @return le chemin trouvé
     */
    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) {
        Graphe<Case> graphe = creerGraphe(carte);
        Noeud<Case> depart = graphe.getNoeud(xDepart, yDepart);
        Noeud<Case> arrivee = graphe.getNoeud(xArrivee, yArrivee);
        List<Noeud<Case>> noeudsChemin = algorithme.trouverChemin(graphe, depart, arrivee);
        if (noeudsChemin == null || noeudsChemin.isEmpty()) {
            return new Chemin(new ArrayList<>());
        }
        return new Chemin(afficherChemin(noeudsChemin));
    }

    /**
     * Crée un graphe à partir d'une carte
     * @param carte la carte à partir de laquelle on crée le graphe
     * @return le graphe créé
     */
    private static Graphe<Case> creerGraphe(Carte carte) {
        Graphe<Case> graphe = new Graphe<>();
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Noeud<Case> currentNoeud = new Noeud<>(carte.getCase(x, y));
                graphe.ajouterNoeud(currentNoeud);
            }
        }
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Noeud<Case> currentNoeud = graphe.getNoeud(x, y);
                try {
                    ajouterAretesVoisines(graphe, currentNoeud, x, y, largeur, hauteur);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return graphe;
    }

    /**
     * Ajoute les arêtes voisines d'un noeud à un graphe
     * @param graphe le graphe auquel on ajoute les arêtes
     * @param currentNoeud le noeud dont on ajoute les arêtes voisines
     * @param x la coordonnée x du noeud
     * @param y la coordonnée y du noeud
     * @param largeur la largeur de la carte
     * @param hauteur la hauteur de la carte
     * @throws Exception lève une exception si les coordonnées sont incorrectes
     */
    private static void ajouterAretesVoisines(Graphe<Case> graphe, Noeud<Case> currentNoeud, int x, int y, int largeur, int hauteur) throws Exception {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < largeur && ny >= 0 && ny < hauteur) {
                Noeud<Case> voisinNoeud = graphe.getNoeud(nx, ny);
                if (voisinNoeud != null) {
                    double cout = calculerCout(currentNoeud.getValeur(), voisinNoeud.getValeur());
                    graphe.ajouterArete(currentNoeud, voisinNoeud, cout);
                    currentNoeud.ajouterVoisin(voisinNoeud);
                }
            }
        }
    }
/**
 * Calcule le coût entre 2 cases
 * @param from le point de départ
 * @param to le point d'arrivée
 * @return le coût entre les 2 points
 */
    private static double calculerCout(Case from, Case to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Les cases 'de' et 'a' doivent être non nulles");
        }
        return from.getTuile().getPenalite() + to.getTuile().getPenalite();
    }
/**
 * Affiche le chemin trouvé
 * @param noeudsChemin les noeuds du chemin
 * @return le chemin trouvé
 */
    private static List<Case> afficherChemin(List<Noeud<Case>> noeudsChemin) {
        List<Case> chemin = new ArrayList<>();
        for (Noeud<Case> noeud : noeudsChemin) {
            chemin.add(noeud.getValeur());
        }
        return chemin;
    }
}