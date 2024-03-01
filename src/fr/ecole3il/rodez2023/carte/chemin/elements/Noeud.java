package fr.ecole3il.rodez2023.carte.chemin.elements;
import java.util.ArrayList;
import java.util.List;

public class Noeud <E>{
    /* Attributs d'un nouvel objet Noeud avec la valeur spécifiée et initialise la liste de voisins*/
    private E valeur;
    private List<Noeud<E>> voisins ;

    /*Constructeur qui crée un nouvel objet Noeud avec la valeur spécifiée et initialise la liste de voisins */
    private Noeud(E valeur) {
        this.valeur = valeur;
        this.voisins = new ArrayList<>();
    }

    /* Méthode qui renvoie la valeur du nœud.*/
    public E getValeur(){
        return valeur;
    }

    /*Méthode qui renvoie la liste des noeuds voisins*/
    public List<Noeud<E>> getVoisin() {
        return voisins;
    }

    /*Méthode qui permet d'ajouter un noeud voisin à la liste des voisins du noeud actuel*/
    public void ajouterVoisin(Noeud<E> voisin){
        voisins.add(voisin);
    }
}
