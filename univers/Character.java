package univers;
import representation.*;

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
                attackPower += 3;
                this.newSkill();
            }
        }
    }

    public CombatNode combat(Monster monster , Event winningNode){
        return new CombatNode(this , monster , winningNode);
    }
}
