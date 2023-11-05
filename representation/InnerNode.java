package representation;

public class InnerNode extends Node{
    private Event nextNode;
    public InnerNode(String[] description, Node nextNode){
        super(description);
        this.nextNode = nextNode;
    }

    public void setnextNode(Event nextNode){
        this.nextNode = nextNode;
    }

    public Event chooseNext(){
        return nextNode;
    }
}