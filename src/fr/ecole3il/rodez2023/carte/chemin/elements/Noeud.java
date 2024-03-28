package fr.ecole3il.rodez2023.carte.chemin.elements;
import java.util.ArrayList;
import java.util.List;

public class Noeud <E>{
    private E valeur;
    private List<Noeud<E>> voisins ;
    /**
     * Crée un objet Noeud avec sa valeur spécifiée 
     * et initialise la liste de voisins
     * @param valeur
     */
    public Noeud(E valeur) {
        this.valeur = valeur;
        this.voisins = new ArrayList<>();
    }

    /**
     * Renvoie la valeur du noeud
     * @return valeur
     */
    public E getValeur(){
        return valeur;
    }
    /**
     * Renvoie la liste des noeuds voisins 
     * @return liste voisins 
     */
    public List<Noeud<E>> getVoisins() {
        return this.voisins;
    }
    /**
     * Ajoute un noeud voisin à la liste des voisins
     * @param voisin
     */
    public void ajouterVoisin(Noeud<E> voisin){
        this.voisins.add(voisin);
    }
    
}
