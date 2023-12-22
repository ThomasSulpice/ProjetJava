package representation;

/** TerminalNode hérite de la classe Node.
 * Un objet de TerminalNode correspond à une feuille dans l'arbre de l'histoire contenant tous les noeuds.
 * @author Thomas Sulpice
 */
public class TerminalNode extends Node{

    public TerminalNode(){
        super();
    }
    public TerminalNode(String[] description){
        super(description);
    }


    /** renvoie le même TerminalNode sur lequel on a appliqué la méthode
     * @return this
     */
    public Node chooseNext(){
        return this;
    }
}
