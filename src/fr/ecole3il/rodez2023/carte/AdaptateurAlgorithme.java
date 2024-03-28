package fr.ecole3il.rodez2023.carte;

import java.util.ArrayList;
import java.util.List;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import java.util.ArrayList;

public class AdaptateurAlgorithme {
    public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) throws Exception{
        Graphe<Case> graphe = creerGraphe(carte);
        Noeud<Case> depart = graphe.getNoeud(xDepart, yDepart);
        Noeud<Case> arrivee = graphe.getNoeud(xArrivee, yArrivee);

        List<Noeud<Case>> chemin = algorithme.trouverChemin(graphe, depart, arrivee);
        List<Case> CaseChemin = new ArrayList<>();
        for (Noeud<Case> noeud : chemin){
            CaseChemin.add(noeud.getValeur());
        }
        return new Chemin(CaseChemin);
    }

    public static Graphe <Case> creerGraphe(Carte carte) throws Exception{
        Graphe<Case> graphe = new Graphe<>();
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();

        
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Noeud<Case> noeudAct = new Noeud<>(carte.getCase(x, y));
                graphe.ajouterNoeud(noeudAct);
            }
        }
        for(int x = 0; x < largeur; x++){
            for(int y = 0; y < hauteur; y++){
                Noeud<Case> noeudAct = new Noeud<>(carte.getCase(x, y));
                ajouterAretesVoisines(graphe, noeudAct, x, y, largeur, hauteur);
            }
        }
        return graphe;
    }

    private static void ajouterAretesVoisines(Graphe<Case> graphe, Noeud<Case> noeudAct, int x, int y, int largeur, int hauteur) throws Exception {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < largeur && ny >= 0 && ny < hauteur) {
                Noeud<Case> voisinNoeud = graphe.getNoeud(nx, ny);
                if (voisinNoeud != null) {
                    double cout = calculerCout(noeudAct.getValeur(), voisinNoeud.getValeur());
                    graphe.ajouterArete(noeudAct, voisinNoeud, cout);
                    noeudAct.ajouterVoisin(voisinNoeud);
                }
            }
        }
    }


    public static double calculerCout(Case from, Case to){
        return from.getTuile().getPenalite() + to.getTuile().getPenalite();
    }

    public static List<Case> afficherChemin(List<Noeud<Case>> chemin){
        List<Case> CaseChemin = new ArrayList<>();
        for (Noeud<Case> noeud : chemin){
            CaseChemin.add(noeud.getValeur());
        }
        return CaseChemin;
    } 
}

