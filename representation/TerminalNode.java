package representation;

public class TerminalNode extends Node{

    public TerminalNode(){
        super();
    }
    public TerminalNode(String[] description){
        super(description);
    }


    public Node chooseNext(){
        return this;
    }
}
