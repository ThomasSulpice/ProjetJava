package representation;

public abstract class Node {
    private String description;
    private static int NodeCpt;
    private final int NodeID;

    public Node(){
        description = "";
        NodeCpt++;
        NodeID = NodeCpt;
    }

    public Node(String description){
        this.description = description;
        NodeCpt++;
        NodeID = NodeCpt;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void display(){
        System.out.println(description);
    }


    public abstract Node chooseNext();
}
