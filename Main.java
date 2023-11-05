import representation.*;
import univers.*;


public class Main {
    public static void main(String[] args){
        TerminalNode nodeWell = new TerminalNode();
        Event[] nodeListWell = new Event[]{nodeWell};
        String[][] classes = new String[][] {{"épéiste" , "une" , "épée"} , {"archer" , "un" , "arc"} , {"mage" , "un" , "bâton magique"}};
        int classNbr = classes.length;


        String[] descNode1 = new String[] {"Bonjour aventurier." , "Tendez votre bras et laissez le destin choisir votre classe!"};
        ChanceNode node1 = new ChanceNode(descNode1 , nodeListWell);

        TerminalNode[] nodeList2 = new TerminalNode[classNbr];
        for (int i = 0 ; i < classNbr ; i++){
            String[] tempDesc = new String[] {"*un soudain éclat vous éblouit*" , "..." ,"Félicitations! Vous avez obtenu " + classes[i][1] + " " + classes[i][2] + "!" , "Vous serez désormais un " +  classes[i][0] + "."};
            nodeList2[i] = new TerminalNode(tempDesc);
        }

        node1.setpotNodes(nodeList2);
        Event node2 = node1.chooseNext();

        node1.display();
        node2.display();


    }
}
