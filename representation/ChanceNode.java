package representation;
import java.util.Arrays;
import java.util.Random;

/** ChanceNode hérite de Node.
 * Un objet de la classe ChanceNode est un Node dont la méthode chooseNext renvoie un Node aléatoirement
 * parmis une liste de Node qu'il prend en argument.
 * Cette probabilité est pour l'instant uniforme.
 * @author Thomas Sulpice
 */
public class ChanceNode extends Node{
    private Event[] potNodes;


    public ChanceNode(String[] description, Event[] potNodes){
        super(description);
        this.potNodes = potNodes;
    }

    public void setpotNodes(Event[] potNodes) {
        this.potNodes = potNodes;
    }

    /** renvoie un Node aléatoirement parmis la liste de noeuds potNodes
     * @return un des noeuds de potNodes aléatoirement (de façon équiprobable)
     */
    public Event chooseNext(){
        int potLen = potNodes.length;
        Random rand = new Random();
        int nextInt = rand.nextInt(potLen);
        return potNodes[nextInt];
    }

    public boolean equals(ChanceNode chanceNode){
        return super.equals(chanceNode) & potNodes == chanceNode.potNodes;
    }

    @Override
    public String toString() {
        return "ChanceNode{" +
                "potNodes=" + Arrays.toString(potNodes) +
                ", description=" + Arrays.toString(description) +
                '}';
    }
}

