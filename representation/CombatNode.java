package representation;

import jdk.jshell.EvalException;
import univers.*;
import univers.Character;

public class CombatNode extends DecisionNode{

    private final Character character;
    private final Monster monster;
    private Event winningNode;



    public CombatNode(Character character , Monster monster , Event winningNode){
        super(new String[] {"Vous rencontrez un(e) " + monster.getName() + "!", "Choisissez une action : "}
                , new Event[]{winningNode , NodeDB.gameOverNode} , new String[]{"0" , "1"} , false);
        this.character = character;
        this.monster = monster;
        if (character.getLevel() > 9){
            description[1] += character.getSkillsUsed()[0].getName() + " (entrez 0) / " + character.getSkillsUsed()[1].getName() + " (entrez 1) (bug, le programme marche qu'à partir de la 3è fois qu'on entre la valeur)";
        }
        else{
            description[1] += character.getSkillsUsed()[0].getName() + " (entrez 0) (bug, le programme marche qu'à partir de la 3è fois qu'on entre la valeur)";
            potAnswers = new String[] {"0"};
        }
    }


    @Override
    public Event chooseNext() {

        float charAtkPower = character.getAttackPower();
        float monsterAtkPower = monster.getAttackPower();
        long dmgDealtLong = Math.round((charAtkPower * character.getSkillsUsed()[Integer.parseInt(input.next())].getMultiplier()));
        int dmgDealt = (int) dmgDealtLong;
        long dmgReceivedLong = Math.round((monsterAtkPower * monster.getSkillUsed().getMultiplier()));
        int dmgReceived = (int) dmgReceivedLong;


        monster.setCurrentHP(monster.getCurrentHP() - dmgDealt);
        System.out.println("Vous utilisez " + character.getSkillsUsed()[Integer.parseInt(input.next())].getName() + "!");
        System.out.println("Vous avez infligé " + dmgDealt + " dégâts à " + monster.getName() + "!" );
        if (monster.getCurrentHP() > 0){
            System.out.println("Votre adversaire n'a plus que " + monster.getCurrentHP() + " PV!" );
        } else {
            System.out.println("Vous avez vaincu votre adversaire!");
            character.addExp(monster.killExp());
            return this.potNodes[0];
        }


        character.setCurrentHP(character.getCurrentHP() - dmgReceived);
        System.out.println("Votre adversaire utilise " + monster.getSkillUsed().getName() + "!");
        System.out.println("Vous avez reçu " + dmgReceived + " dégâts!");
        if (character.getCurrentHP() > 0){
            System.out.println("Vous n'avez plus que " + character.getCurrentHP() + " PV!" );
            description = new String[] {description[description.length - 1]};
            return this;
        } else {
            System.out.println("Vous êtes mort!");
            return this.potNodes[1];
        }
    }


    public void combatLoop(){
        while (character.getCurrentHP() > 0 && monster.getCurrentHP() > 0){
            this.chooseNext().display();
        }
        monster.restoreHP();
    }
}
