package representation;

import univers.*;
import univers.Character;

import java.util.Arrays;

/** CombatNode hérite de DecisionNode.
 * Un objet de CombatNode a 2 attributs en plus, character et monster, qui correspondent simplement
 * au personnage et au monstre qui interviennent dans le combat.
 * @author Thomas Sulpice
 */
public class CombatNode extends DecisionNode{

    private final Character character;
    private final Monster monster;


    public CombatNode(Character character , Monster monster , Event winningNode){
        super(new String[] {"Vous rencontrez un(e) " + monster.getName() + "!", "Choisissez une action : "}
                , new Event[]{winningNode , NodeDB.gameOverNode} , new String[]{"0" , "1"} , false);
        this.character = character;
        this.monster = monster;
        if (character.getLevel() > 9){
            description[1] += character.getSkillsUsed()[0].getName() + " (entrez 0) / " + character.getSkillsUsed()[1].getName() + " (entrez 1)";
        }
        else{
            description[1] += character.getSkillsUsed()[0].getName() + " (entrez 0)";
            potAnswers = new String[] {"0"};
        }
    }


    /** réalise un tour d'un combat (Character et Monster) et renvoie un Node en fonction de l'issue
     * @return cette instance de CombatNode si ni le Character ni le Monster meurt, le 1er élément de PotNodes si le monstre meurt, le 2è sinon
     */
    @Override
    public Event chooseNext() {

        int indexAtkUsed = Integer.parseInt(inputText);
        float charAtkPower = character.getAttackPower();
        float monsterAtkPower = monster.getAttackPower();
        long dmgDealtLong = Math.round((charAtkPower * character.getSkillsUsed()[indexAtkUsed].getMultiplier()));
        int dmgDealt = (int) dmgDealtLong;
        long dmgReceivedLong = Math.round((monsterAtkPower * monster.getSkillUsed().getMultiplier()));
        int dmgReceived = (int) dmgReceivedLong;



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        monster.setCurrentHP(monster.getCurrentHP() - dmgDealt);
        System.out.println("Vous utilisez " + character.getSkillsUsed()[indexAtkUsed].getName() + "!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Vous avez infligé " + dmgDealt + " dégâts à " + monster.getName() + "!" );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (monster.getCurrentHP() > 0){
            System.out.println("Votre adversaire n'a plus que " + monster.getCurrentHP() + " PV!" );
        } else {
            System.out.println("Vous avez vaincu votre adversaire!");
            character.addExp(monster.killExp());
            return this.potNodes[0];
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        character.setCurrentHP(character.getCurrentHP() - dmgReceived);
        System.out.println("Votre adversaire utilise " + monster.getSkillUsed().getName() + "!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Vous avez reçu " + dmgReceived + " dégâts!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (character.getCurrentHP() > 0){
            System.out.println("Vous n'avez plus que " + character.getCurrentHP() + " PV!" );
            description = new String[] {description[description.length - 1]};
            return this;
        } else {
            System.out.println("Vous êtes mort!");
            return this.potNodes[1];
        }

    }


    /** effectue chooseNext et display sur le Node renvoyé jusqu'à que soit le Character,
     * soit le Monster atteigne 0 HP.
     */
    public void combatLoop(){
        while (character.getCurrentHP() > 0 && monster.getCurrentHP() > 0){
            this.chooseNext().display();
        }
        monster.restoreHP();
    }

    public boolean equals(CombatNode combatNode){
        return super.equals(combatNode) & character.equals(combatNode.character) & monster.equals(combatNode.monster);
    }

    @Override
    public String toString() {
        return "CombatNode{" +
                "character=" + character +
                ", monster=" + monster +
                ", potAnswers=" + Arrays.toString(potAnswers) +
                ", freeChoice=" + freeChoice +
                ", description=" + Arrays.toString(description) +
                '}';
    }
}
