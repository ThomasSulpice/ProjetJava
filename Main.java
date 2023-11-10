import representation.*;
import univers.*;
import univers.Character;


public class Main {
    public static void main(String[] args){
        String[][] classes = new String[][] {{"épéiste" , "une" , "épée"} , {"archer" , "un" , "arc"} , {"mage" , "un" , "bâton magique"}};
        int classNbr = classes.length;
        Character character;

        NodeDB.Node1.display();

        String characterName = NodeDB.Node1.getPotAnswers()[0];

        DecisionNode Node2 = new DecisionNode(new String[] {"Ravi de vous rencontrer, " + characterName +".", "Choisissez donc une arme." , "épée / arc / baguette"} ,
                NodeDB.nodeArrayWell , new String[]{"épée" , "arc" , "baguette"} , false);

        NodeDB.Node1.setPotNodes(new Event[] {Node2});

        Event[] NodeArray3 = new Event[classNbr];
        for (int i = 0 ; i < classNbr ; i++){
            String[] tempDesc = new String[] {"Vous avez donc choisi " + classes[i][1] + " " + classes[i][2] + "!" ,
                    "Vous serez désormais un " +  classes[i][0] + "!"};
            Event tempEvent = new ImageNode(new SoundNode(new InnerNode(tempDesc , NodeDB.nodeWell) , "sound_db/test.wav") , "image_db/test.jpg");
            NodeArray3[i] = tempEvent;
        }

        Node2.setPotNodes(NodeArray3);
        Node2.display();

        if (Node2.getAnswerNbr() == 0){
            character = new Swordsman(characterName);
        } else if (Node2.getAnswerNbr() == 1){
            character = new Archer(characterName);
        } else {
            character = new Mage(characterName);
        }
        Event Node3 = Node2.chooseNext();
        Node3.display();

        InnerNode Node4 = new InnerNode(new String[]{"Maintenant que vous avez choisi votre classe, allons tester vos compétences." , "Suivez-Moi" , "..." ,
        "Commencez par attaquer cet épouvantail."} , character.combat(MonsterDB.epouvantail , NodeDB.ggNode));

        Node4.display();
        Event tempNode5 = Node4.chooseNext();
        CombatNode Node5 = (CombatNode) tempNode5;

        Node5.display();
        Node5.combatLoop();
        System.exit(0);



    }
}
