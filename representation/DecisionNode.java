package representation;
import java.util.Scanner;

public class DecisionNode extends Node{

    protected Event[] potNodes;
    protected String[] potAnswers;
    protected Scanner input;
    protected int answerNbr;



    public DecisionNode(String[] description , Event[] potNodes , String[] potAnswers){
        super(description);
        this.potNodes = potNodes;
        this.potAnswers = potAnswers;
    }

    @Override
    public void display(){
        super.display();
        int answerLength = potAnswers.length;
        input = new Scanner(System.in);
        boolean isInPotNodes = false;
        while (isInPotNodes == false){
            for (int i=0 ; i<answerLength ; i++){
                if (potAnswers[i].equals(input.next())){
                    isInPotNodes = true;
                    answerNbr = i;
                }
            }
            if (isInPotNodes == false){
                System.out.println("Votre choix est incorrect. Veuillez réessayer.");
                input = new Scanner(System.in);
            }
        }
    }

    public Event chooseNext(){
        return potNodes[answerNbr];
    }
}