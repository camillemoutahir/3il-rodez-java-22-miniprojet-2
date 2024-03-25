package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*Question : Quelle structure de données pourrait être utilisée pour stocker les relations entre les nœuds du graphe
et les informations associées à ces relations, comme les coûts des arêtes ?
Réponse : Collections et plus précisement : map, listes et set
*/

/*Question : Pourquoi pensez-vous que les classes Noeud et Graphe ont été définies avec des paramètres génériques ?
Réponse : On utilise des paramètres génériques comme ça on peut changer leur type pour avoir n'importe quel type de paramètres (int, String, etc...)
 */

public class Graphe <E> {
    private List<E> graphe;
    private Map<Noeud<E>, List<Noeud<E>>> adjacence;

    public Graphe(){
        this.graphe = null;
        this.adjacence = null;
    }

    /**
     * Ajoute un noeud au graphe s'il n'exite pas déjà dans le graphe
     * @param noeud
     */
    public void ajouterNoeud(Noeud<E> noeud){
        if (!adjacence.containsKey(noeud)){
            adjacence.put(noeud, new ArrayList<>());
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
        if(!adjacence.containsKey(depart)){
            ajouterNoeud(depart);
        }
        if(!adjacence.containsKey(arrivee)){
            ajouterNoeud(arrivee);
        }
        adjacence.get(depart).add(arrivee);
        //TODO ajouter cout arete
    }

    /**
     * Renvoie coût de l'arête entre les 2 noeuds spécifiés
     * @param depart
     * @param arrivee
     * @return coût de l'arête entre les 2 noeuds spécifiés
     */
    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee){
        return 0.0;
    }

    /**
     * Renvoie liste contenant tous les noeuds du graphe
     * @return liste contenant les noeuds du graphe
     */
    public List<Noeud<E>> getNoeuds(){
        return new ArrayList<>(adjacence.keySet());
    }
    
    /**
     * Renvoie liste contenant tous les voisins d'un noeud spécifié
     * @param noeud
     * @return liste contenant tous les voisins du noeud
     */
    public List<Noeud<E>> getVoisins(Noeud<E> noeud){
        return adjacence.getOrDefault(noeud, new ArrayList<>());
    }
}
