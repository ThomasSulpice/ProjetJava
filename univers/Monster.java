package univers;

public class Monster extends Entity{
    Skill skillUsed;
    public Monster(String name , Skill[] skills , int level){
        super(name , skills);
        this.level = level;
        maxHP = 100 + 10*level;
        attackPower = 30 + 3*level;
        skillUsed = skills[0];
        currentHP = maxHP;
    }

    public Skill getSkillUsed() {
        return skillUsed;
    }

    public void setSkillUsed(Skill skillUsed) {
        this.skillUsed = skillUsed;
    }

    public int killExp(){
        float lvl = (float) level;
        return (int) (1 + Math.round(level * (50 + (level - 1) * 0.5) / 7.0));
    }
}
