package representation;
import java.util.Random;

public class ChanceNode extends Node{
    private final Node[] potNodes;


    public ChanceNode(String description, Node[] potNodes){
        super(description);
        this.potNodes = potNodes;
    }

    public Node chooseNext(){
        int potLen = potNodes.length;
        Random rand = new Random();
        int nextInt = rand.nextInt(potLen);
        return potNodes[nextInt];
    }
}