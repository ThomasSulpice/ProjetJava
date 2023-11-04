package representation;

public class ChanceNode extends Node{
    public ChanceNode(String description){
        super(description);
    }

    public Node chooseNext(){
        return this;
    }
}