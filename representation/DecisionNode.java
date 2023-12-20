package representation;
import java.util.Scanner;

public class DecisionNode extends Node{

    protected Event[] potNodes;
    protected String[] potAnswers;
    protected String inputText;
    protected int answerNbr;
    protected boolean freeChoice;



    public DecisionNode(String[] description , Event[] potNodes , String[] potAnswers , boolean freeChoice){
        super(description);
        this.potNodes = potNodes;
        this.potAnswers = potAnswers;
        this.freeChoice = freeChoice;
    }

    public Event[] getPotNodes() {
        return potNodes;
    }

    public void setPotNodes(Event[] potNodes) {
        this.potNodes = potNodes;
    }

    public String[] getPotAnswers() {
        return potAnswers;
    }

    public void setPotAnswers(String[] potAnswers) {
        this.potAnswers = potAnswers;
    }

    public boolean isFreeChoice() {
        return freeChoice;
    }

    public void setFreeChoice(boolean freeChoice) {
        this.freeChoice = freeChoice;
    }

    public int getAnswerNbr() {
        return answerNbr;
    }

    public void setAnswerNbr(int answerNbr) {
        this.answerNbr = answerNbr;
    }

    @Override
    public void display(){
        super.display();
        if (freeChoice != true){
            Scanner input = new Scanner(System.in);
            int answerLength = potAnswers.length;
            boolean isInPotNodes = false;
            while (isInPotNodes == false){
                inputText = input.next();
                for (int i=0 ; i<answerLength ; i++){
                    if (potAnswers[i].equals(inputText)){
                        isInPotNodes = true;
                        answerNbr = i;
                        break;
                    }
                }
                if (isInPotNodes == false){
                    System.out.println("Votre choix est incorrect. Veuillez réessayer.");
                    input = new Scanner(System.in);
                }
            }
        }
        else{
            Scanner input = new Scanner(System.in);
            potAnswers = new String[] {input.next()};
        }

    }

    public Event chooseNext(){
        if (freeChoice == true){
            return potNodes[0];
        }
        else{
            return potNodes[answerNbr];
        }
    }
}