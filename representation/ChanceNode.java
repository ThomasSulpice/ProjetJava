package representation;
import java.util.Random;

public class ChanceNode extends Node{
    private final Event[] potNodes;


    public ChanceNode(String description, Node[] potNodes){
        super(description);
        this.potNodes = potNodes;
    }

    public Event chooseNext(){
        int potLen = potNodes.length;
        Random rand = new Random();
        int nextInt = rand.nextInt(potLen);
        return potNodes[nextInt];
    }
}