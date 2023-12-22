package univers;
import representation.*;

/** Character hérite de la classe Entity.
 * Character contient tous les attributs et les méthodes nécessaires pour monter le niveau et changer les
 * sorts d'une de ses instances.
 * @author Thomas Sulpice
 */
public class Character extends Entity{
    protected int experience;
    protected int expLvUp;
    protected Skill[] skillsUsed = new Skill[2];

    public Character(){
        super();
        experience = 0;
        expLvUp = 8;
    }

    public Character(String name , Skill[] skills){
        super(name , skills);
        experience = 0;
        expLvUp = 8;
        skillsUsed[0] = skills[0];
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExpLvUp() {
        return expLvUp;
    }

    public void setExpLvUp(int expLvUp) {
        this.expLvUp = expLvUp;
    }

    public Skill[] getSkillsUsed() {
        return skillsUsed;
    }

    public void setSkillsUsed(Skill[] skillsUsed) {
        this.skillsUsed = skillsUsed;
    }

    public int nextLevel(){
        return (level + 1)^3 - level^3;
    }


    /** met à jour les sorts utilisés d'un Character selon les sorts de plus haut niveau qu'il peut utiliser
     * parmis skills
     */
    public void newSkill(){
        for (Skill skill : skills){
            if (skill.levelReq == level){
                if (skill instanceof SkillSingle){
                    skillsUsed[0] = skill;
                }
                else {
                    skillsUsed[1] = skill;
                }
                break;

}
        }
                }

    /** met à jour l'expérience du Character, et si besoin le fait monter de niveau et met à jour ses stats
     * et ses skills
     * @param expValue l'expérience gagnée par le Character
     */
    public void addExp(int expValue){
        experience += expValue;
        if (level == 100){
            return;
        }
        else {
            while (experience > expLvUp){
                level++;
                experience -= expLvUp;
                expLvUp = (level + 1)^3 - level^3;
                maxHP += 10;
                attackPower += 4;
                this.newSkill();
            }
        }
    }

    /** génère un CombatNode
     * @param monster Monster combattu par Character
     * @param winningNode Node suivant de l'histoire en cas de victoire
     * @return le CombatNode généré selon ces paramètres
     */
    public CombatNode combat(Monster monster , Event winningNode){
        return new CombatNode(this , monster , winningNode);
    }


    public boolean equals(Character character){
        return super.equals(character) & experience == character.experience;
    }

}
