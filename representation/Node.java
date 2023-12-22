package representation;

import java.util.Arrays;

/** Node est une classe abstraite contenant tous les attributs et les méthodes dont tout noeud a besoin.
 * @author Thomas Sulpice
 */
public abstract class Node implements Event {
    protected String[] description;
    private static int NodeCpt;
    private final int NodeID;

    public Node(){
        description = new String[] {""};
        NodeCpt++;
        NodeID = NodeCpt;
    }

    public Node(String[] description){
        this.description = description;
        NodeCpt++;
        NodeID = NodeCpt;
    }

    public void setDescription(String[] description){
        this.description = description;
    }

    /** affiche chaque ligne de description, avec un délai de 1sec entre chaque ligne
     */
    public void display(){
        for (String desc : description){
            System.out.println(desc);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public abstract Event chooseNext();


    public boolean equals(Node node){
        return Arrays.equals(description, node.description) & NodeID == node.NodeID;
    }

    @Override
    public String toString() {
        return "Node{" +
                "description=" + Arrays.toString(description) +
                ", NodeID=" + NodeID +
                '}';
    }
}
