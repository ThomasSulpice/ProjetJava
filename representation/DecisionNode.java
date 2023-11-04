package representation;


public class DecisionNode extends Node{
    private int outcomes;
    public DecisionNode(String description){
        super(description);
    }

    public Node chooseNext(){
        return this;
    }
}