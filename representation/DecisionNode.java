package representation;
import java.util.Scanner;

public class DecisionNode extends Node{

    public DecisionNode(String description){
        super(description);
    }

    public Node chooseNext(){
        return this;
    }
}