package univers;

import java.util.Arrays;

/** Entity contient tous les attributs et méthodes nécessaires pour un objet qui
 * pourrait être dans un combat, donc ici n'importe quel objet des classes Character et Monster.
 * @author Thomas Sulpice
 */
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
        attackPower = 40;
        maxHP = 100;
        currentHP = maxHP;
    }

    public Entity(String name , Skill[] skills){
        this.name = name;
        level = 1;
        attackPower = 40;
        maxHP = 100;
        currentHP = maxHP;
        this.skills = skills;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setCurrentHP(int hp){
        currentHP = hp;
    }

    public void restoreHP(){
        currentHP = maxHP;
    }

    public boolean equals(Entity entity){
        return name == entity.name & level == entity.level & currentHP == entity.currentHP & skills == entity.skills;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", attackPower=" + attackPower +
                ", maxHP=" + maxHP +
                ", currentHP=" + currentHP +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}
