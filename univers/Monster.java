package univers;

public class Monster extends Entity{
    Skill skillUsed;
    public Monster(String name , Skill[] skills , int level){
        super(name , skills);
        this.level = level;
        maxHP = 12 + 3*level;
        attackPower = 4 + level;
        skillUsed = skills[0];
    }

    public int killExp(){
        float lvl = (float) level;
        return (int) (1 + Math.round(level * (50 + (level - 1) * 0.5) / 7.0));
    }
}
