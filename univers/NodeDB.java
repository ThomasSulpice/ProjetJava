package univers;

import representation.*;

public class NodeDB {

    public final static TerminalNode gameOverNode = new TerminalNode(new String[]{"Game Over"});
    public final static TerminalNode ggNode = new TerminalNode(new String[]{"Félicitation! Vous avez remporté cette partie"});
    public final static TerminalNode nodeWell = new TerminalNode();
    public final static Event[] nodeArrayWell = new Event[]{nodeWell};

    public final static InnerNode Node4 = new InnerNode(new String[] {"Maintenant, allons tester vos nouvelles compétences. Suivez-moi."} , nodeWell);

    public static DecisionNode Node1 = new DecisionNode(new String[] {"Bienvenue aventurier! Quel est votre nom?"} , new Event[] {nodeWell} , new String[] {""} , true);




}
