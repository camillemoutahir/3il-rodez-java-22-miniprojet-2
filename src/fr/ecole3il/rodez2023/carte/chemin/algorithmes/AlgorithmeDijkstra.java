package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

public class AlgorithmeDijkstra <E> implements AlgorithmeChemin<E>{
    //Initialisation des structures de données
    @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        // Initialisation des structures de données
        Map<Noeud<E>, Double> couts = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> predecesseurs = new HashMap<>();
    // Initialisation des prédecesseurs et ds coûts
    //File de priorité pour les noeuds à explorer

    //Exploration des noeuds

    // Retourne le chemin le plus court trouvé
    return null;
}
}
