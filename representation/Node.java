package representation;

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

    public void display(){
        for (String desc : description){
            System.out.println(desc);
        }
    }


    public abstract Event chooseNext();
}
