package fr.ecole3il.rodez2023.carte.chemin.algorithmes;
import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

import java.util.ArrayList;
import java.util.Comparator;
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
        
        /*Initialisation des couts */
        for (Noeud<E> noeud : graphe.getNoeuds()){
            //On initialise le cout total estime de chaque noeud à l'infini
            coutEstime.put(noeud, Double.POSITIVE_INFINITY);
            coutReel.put(noeud, Double.POSITIVE_INFINITY);
            listePred.put(noeud, null);
        }
         //On initialise le cout actuel du noeud de depart à 0
        coutEstime.put(depart,0.0);
        coutReel.put(depart,0.0);
        /*File de priorité qui classe les noeuds à explorer par leur cout total estime*/
        PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<>(Comparator.comparingDouble(coutEstime::get));
        filePriorite.add(depart);

        /*Partie 2 : Boucle principale*/
        //On n'arrete pas l'algo tant que la file de priorite n'est pas vide
        while (!filePriorite.isEmpty()){
            //On cree un noeud de reference dans la file de priorite
            Noeud<E> noeudRef = filePriorite.poll();
            //Si le noeud de reference est le noeud d'arrivee, on arrete l'algo
            if(noeudRef.equals(arrivee)){
                break;
            }
            
            for (Noeud<E> voisin : graphe.getVoisins(noeudRef)){
                double coutTotal = coutReel.get(noeudRef) + graphe.getCoutArete(noeudRef, voisin);
                // Si le cout total de notre reference est inferieur au cout du noeud voisin
                if (coutTotal < coutReel.get(voisin)) {
                    //Mise à jour du cout et predecesseur du voisin
                    coutReel.put(voisin, coutTotal);
                    listePred.put(voisin, noeudRef);
                    //Ajout du voisin dans la file de priorite
                    filePriorite.add(voisin);
                    double coutEstimeVoisin = coutTotal + heuristique(voisin, arrivee);

                    if (coutEstimeVoisin < coutEstime.get(voisin)) {
                        coutEstime.put(voisin, coutEstimeVoisin);
                    }
                }
            }
        }

        /*Partie 3 : Reconstruction du chemin */
        List<Noeud<E>> chemin = new ArrayList<>();
        Noeud <E> noeudA = arrivee;
        //On remonte les precesseurs du noeud d'arrivee jusqu'au noeud de depart
        while(noeudA !=null){
            chemin.addFirst(noeudA);
            noeudA = listePred.get(noeudA);
        }
        return chemin;
    }
    /**
     * Renvoie la distance entre les coordonnees spatiales de 2 noeuds
     * @param noeud
     * @param arrivee
     * @return distance en double (réel)
     */
    private double heuristique(Noeud<E> noeud, Noeud<E> arrivee) {
        double deltaX = Math.abs(noeud.getX() - arrivee.getX());
        double deltaY = Math.abs(noeud.getY() - arrivee.getY());
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
