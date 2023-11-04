package representation;

public class InnerNode extends Node{
    private Node nextNode;
    public InnerNode(String description, Node nextNode){
        super(description);
        this.nextNode = nextNode;
    }

    public Node chooseNext(){
        return nextNode;
    }
}