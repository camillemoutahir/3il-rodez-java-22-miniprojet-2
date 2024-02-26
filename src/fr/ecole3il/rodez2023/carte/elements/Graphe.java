package fr.ecole3il.rodez2023.carte.elements;

import java.util.List;
import java.util.Iterator;

/*Question : Quelle structure de données pourrait être utilisée pour stocker les relations entre les nœuds du graphe
et les informations associées à ces relations, comme les coûts des arêtes ?
Réponse : Collections
*/

/*Question : Pourquoi pensez-vous que les classes Noeud et Graphe ont été définies avec des paramètres génériques ?
Réponse : On utilise des paramètres génériques comme ça on peut changer leur type pour avoir n'importe quel type de paramètres (int, String, etc...)
 */

public class Graphe <E> {
    private List<E> graphe;

    /**
     * Ajoute un noeud au graphe si n'exite pas déjà dans le graphe
     * @param noeud
     */
    public void ajouterNoeud(Noeud<E> noeud){
        if (!graphe.contains(noeud)){
            ajouterNoeud(noeud);
        }
    }
    /*Cette méthode ajoute une arête pondérée entre deux nœuds du graphe. Elle prend en paramètre le nœud de départ, le nœud d'arrivée et le coût de l'arête.
    Si les nœuds de départ et d'arrivée n'existent pas encore dans le graphe, ils sont ajoutés en utilisant la méthode ajouterNoeud.
    Ne pas oublier d'initialiser l'arête à la matrice d'adjacence associée au nœud de départ.
     */

    /**
     * Ajoute une arête pondéré entre 2 noeuds du graphe
     * @param depart
     * @param arrivee
     * @param cout de l'arrete
     */
    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout){
        double arete =0;
        if(!graphe.contains(depart)){
            ajouterNoeud(depart);
        }
        if(!graphe.contains(arrivee)){
            ajouterNoeud(arrivee);
        }
    }

    /*Cette méthode renvoie le coût de l'arête entre deux nœuds spécifiés.*/
    //TODO get cout arete

    /**
     * Renvoie coût de l'arête entre les 2 noeuds spécifiés
     * @param depart
     * @param arrivee
     * @return coût de l'arête entre les 2 noeuds spécifiés
     */
    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee){
        return 0.0;
    }

    /*Cette méthode renvoie une liste contenant tous les nœuds du graphe.*/

    /**
     *
     * @return
     */
    public List<Noeud<E>> getNoeuds(){
        return null;
    }
    /*Cette méthode renvoie une liste contenant tous les voisins d'un nœud spécifié. Si le nœud n'existe pas dans le graphe, elle renvoie une liste vide*/

    /**
     * Renvoie liste contenant tous les voisins d'un noeud spécifié
     * @param noeud
     * @return liste
     */
    public List<Noeud<E>> getVoisins(Noeud<E> noeud){
        return null;
    }
}
