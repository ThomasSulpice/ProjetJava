package representation;
import java.util.Scanner;

public class DecisionNode extends Node{

    public DecisionNode(String[] description){
        super(description);
    }

    public Event chooseNext(){
        return this;
    }
}