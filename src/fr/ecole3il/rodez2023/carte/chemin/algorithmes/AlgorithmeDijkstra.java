package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

public class AlgorithmeDijkstra <E> implements AlgorithmeChemin<E>{
    /*Partie 1 : Initialisation des structures de données*/
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        /*Initialisation des structures de données*/
        Map<Noeud<E>, Double> listeCouts = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> listePred = new HashMap<>();
        /**
         * Initialisation des prédecesseurs et des coûts de chaque noeud
         * */
        for(Noeud<E> noeud : graphe.getNoeuds()){
            //Cout des noeuds (sauf celui de depart) mis à l'infini
            listeCouts.put(noeud, Double.POSITIVE_INFINITY);
            //Predecesseurs de chaque noeud initialisés à 0
            listePred.put(noeud,null);
        }
        // Cout du noeud de depart initialisé à 0
        listeCouts.put(depart,0.0);

        /*File de priorité qui classe les noeuds à explorer par leur cout actuel*/
        PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<>(Comparator.comparingDouble(listeCouts::get));
    /*Partie 2 : Exploration des noeuds*/
    

    /*Partie 3 : Retourne du chemin le plus court trouvé*/
    return null;
}
}