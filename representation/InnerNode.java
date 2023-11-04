package representation;

public class InnerNode extends Node{
    private Node Node1;
    private Node Node2;
    private Node Node3;
    private Node Node4;

    public InnerNode(String description , Node Node1 , Node Node2 , Node Node3 , Node Node4){
        super(description);
        this.Node1 = Node1;
        this.Node2 = Node2;
        this.Node3 = Node3;
        this.Node4 = Node4;
    }

    public Node chooseNext(){
        return this;
    }

}