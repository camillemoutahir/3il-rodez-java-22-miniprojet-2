package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.List;

import fr.ecole3il.rodez2023.carte.chemin.elements.Graphe;
import fr.ecole3il.rodez2023.carte.chemin.elements.Noeud;

public interface AlgorithmeChemin<E> {
    /**
     * Trouve un chemin entre un noeud de départ et un noeud d'arrivée dans un graphe donné
     * @param graphe
     * @param depart
     * @param arrivee
     * @return liste des noeuds du chemin trouvé entre le noeud de départ et le noeud d'arrivée dans le graphe
     */
    List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee);
}

/*Question : Pourquoi pensez-vous que la création d'une interface est une bonne pratique dans ce contexte ?
 * Réponse : L'interface est une bonne pratique car elle permet de définir un contrat entre les classes qui l'implémentent.
 */