package univers;

public abstract class Entity {
    protected String name;
    protected int level;
    protected int attackPower;
    protected int maxHP;
    protected int currentHP;
    protected Skill[] skills;

    public Entity(){
        name = "";
        level = 1;
        attackPower = 4;
        maxHP = 12;
        currentHP = maxHP;
    }

    public Entity(String name , Skill[] skills){
        this.name = name;
        level = 1;
        attackPower = 4;
        maxHP = 12;
        currentHP = maxHP;
        this.skills = skills;
    }

    public void restoreHP(){
        currentHP = maxHP;
    }
}
