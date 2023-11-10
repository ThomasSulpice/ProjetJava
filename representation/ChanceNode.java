package representation;
import java.util.Random;

public class ChanceNode extends Node{
    private Event[] potNodes;


    public ChanceNode(String[] description, Event[] potNodes){
        super(description);
        this.potNodes = potNodes;
    }

    public void setpotNodes(Event[] potNodes) {
        this.potNodes = potNodes;
    }

    public Event chooseNext(){
        int potLen = potNodes.length;
        Random rand = new Random();
        int nextInt = rand.nextInt(potLen);
        return potNodes[nextInt];
    }

}

