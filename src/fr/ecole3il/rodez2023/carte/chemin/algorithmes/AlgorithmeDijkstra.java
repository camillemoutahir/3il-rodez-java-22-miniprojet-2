package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.ArrayList;
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
    //On n'arrete pas l'algo tant que la file de priorite n'est pas vide
    while (!filePriorite.isEmpty()){
        //On cree un noeud de reference dans la file de priorite
        Noeud<E> noeudActuel = filePriorite.poll();
        //Si le noeud de ref est le noeud d'arrivee, on arrete l'algo vu qu'on a déjà trouvé le noeud d'arrivee
        if(noeudActuel.equals(arrivee)){
            break;
        }
        //Sinon on calcule le cout de chaque voisin du noeud de reference
        for (Noeud<E> voisin : graphe.getVoisins(noeudActuel)){
            double coutTotal = listeCouts.get(noeudActuel) + graphe.getCoutArete(noeudActuel, voisin);
            //Si le cout totale est inferieur au cout du noeud voisin
            if (coutTotal<listeCouts.get(voisin)){
                //Mise à jour du cout et predecesseur du voisin
                listeCouts.put(voisin, coutTotal);
                listePred.put(voisin, noeudActuel);
                //Ajouter le voisin à la file de priorite
                filePriorite.add(voisin);
            }
        }
    }
    /*Partie 3 : Retourne du chemin le plus court trouvé*/
    //Creation du chemin (liste composee de plusieurs noeuds)
    List<Noeud<E>> chemin = new ArrayList<>();
    Noeud<E> noeudA = arrivee;
    //On remonte les precesseurs du noeud d'arrivee jusqu'au noeud de depart
    while (noeudA!= null){
        chemin.addFirst(noeudA);
        noeudA = listePred.get(noeudA);
    }
    return chemin;
    }
}