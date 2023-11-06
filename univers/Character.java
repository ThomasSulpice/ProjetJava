package univers;

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
                maxHP += 3;
                attackPower += 1;
                this.newSkill();
            }
        }
    }
}
