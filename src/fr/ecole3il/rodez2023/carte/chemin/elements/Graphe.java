package fr.ecole3il.rodez2023.carte.chemin.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*Question : Quelle structure de données pourrait être utilisée pour stocker les relations entre les nœuds du graphe
et les informations associées à ces relations, comme les coûts des arêtes ?
Réponse : Collections et plus précisement : map, listes et set
*/

import fr.ecole3il.rodez2023.carte.elements.Case;

/*Question : Pourquoi pensez-vous que les classes Noeud et Graphe ont été définies avec des paramètres génériques ?
Réponse : On utilise des paramètres génériques comme ça on peut changer leur type pour avoir n'importe quel type de paramètres (int, String, etc...)
 */

public class Graphe <E> {
    private Map<Noeud<E>, Map<Noeud<E>, Double>> listeNoeuds;

    /**
     * Constructueur Graphe qui initialise listeNoeuds
     */
    public Graphe(){
        this.listeNoeuds = new HashMap<>();
    }

    /**
     * Ajoute un noeud au graphe s'il n'exite pas déjà dans le graphe
     * @param noeud
     */
    public void ajouterNoeud(Noeud<E> noeud){
        if (!this.listeNoeuds.containsKey(noeud)){
            this.listeNoeuds.put(noeud, new HashMap<>());
        }
    }

    /**
     * Ajoute une arête pondérée entre 2 noeuds du graphe
     * @param depart
     * @param arrivee
     * @param cout de l'arete
     */
    public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout){
        /*On vérifie si les noeuds de départ et d'arrivee 
        existent sinon les creer*/
        if(!this.listeNoeuds.containsKey(depart)){
            ajouterNoeud(depart);
        }
        if(!this.listeNoeuds.containsKey(arrivee)){
            ajouterNoeud(arrivee);
        }
        this.listeNoeuds.get(depart).put(arrivee,cout);
    }

    /**
     * Renvoie coût de l'arête entre les 2 noeuds spécifiés
     * @param depart noeud de départ
     * @param arrivee noeud d'arrivee
     * @return coût de l'arête entre les 2 (si un des noeuds n'existent pas renvoie 0)
     */
    public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee){
        if (this.listeNoeuds.containsKey(depart)&& this.listeNoeuds.containsKey(arrivee)){
            return this.listeNoeuds.get(depart).get(arrivee);
        }
        return 0;
    }

    /**
     * Renvoie liste contenant tous les noeuds du graphe
     * @return liste contenant les noeuds du graphe
     */
    public List<Noeud<E>> getNoeuds(){
        return new ArrayList<>(this.listeNoeuds.keySet());
    }
    
    /**
     * Renvoie liste contenant tous les voisins d'un noeud spécifié
     * @param noeud noeud dont on cherche tous les voisins
     * @return liste contenant tous les voisins de ce noeud
     */
    public List<Noeud<E>> getVoisins(Noeud<E> noeud){
        return noeud.getVoisins();
    }
    
    /**
     * Récupère le nœud correspondant aux coordonnées spatiales spécifiées.
     * @param x coordonnée x du nœud
     * @param y coordonnée y du nœud
     * @return le nœud correspondant à ces coordonnées spatiales
     */
    public Noeud<E> getNoeud(int nx, int ny) {
        for (Noeud<E> noeud : listeNoeuds.keySet()) {
            Case c = (Case) noeud.getValeur();
            if (c.getX() == nx && c.getY() == ny) {
                return noeud;
            }
        }
        return null;
    }
}




