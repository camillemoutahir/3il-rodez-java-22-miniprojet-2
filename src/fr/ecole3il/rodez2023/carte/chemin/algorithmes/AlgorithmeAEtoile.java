package fr.ecole3il.rodez2023.carte.chemin.algorithmes;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AlgorithmeAEtoile<E> implements AlgorithmeChemin<E> {
    /*Partie 1 :Initialisation */
     @Override
    public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
        Map<Noeud<E>, Noeud<E>> listePred = new HashMap<>();
        Map<Noeud<E>, Double> coutEstime = new HashMap<>();
        Map<Noeud<E>, Double> coutReel = new HashMap<>();

        for (Noeud<E> noeud : graphe.getNoeuds()){
            coutEstime.put(noeud, Double.POSITIVE_INFINITY);
            coutReel.put(noeud, Double.POSITIVE_INFINITY);
            listePred.put(noeud, null);
        }
        coutEstime.put(depart,0.0);
        coutReel.put(depart,0.0);

        PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<>(Comparator.comparingDouble(coutEstime::get));
        filePriorite.add(depart);


        return null; 
    }
}
