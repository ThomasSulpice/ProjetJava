package univers;

/** Monster hérite de la classe Entity.
 * Comparé à Character, un objet de la classe Monster ne prend qu'un seul skill en attribut,
 * et a en plus d'Entity une méthode permettant de calculer l'exp gagné par le Character le combattant.
 * @author Thomas Sulpice
 */
public class Monster extends Entity{
    Skill skillUsed;
    public Monster(String name , Skill[] skills , int level){
        super(name , skills);
        this.level = level;
        maxHP = 100 + 10*(level-1);
        attackPower = 30 + 3*(level-1);
        skillUsed = skills[0];
        currentHP = maxHP;
    }

    public Skill getSkillUsed() {
        return skillUsed;
    }

    public void setSkillUsed(Skill skillUsed) {
        this.skillUsed = skillUsed;
    }

    /**
     * @return l'expérience gagnée lorsque le monstre est vaincu
     */
    public int killExp(){
        float lvl = (float) level;
        return (int) (1 + Math.round(level * (50 + (level - 1) * 0.5) / 7.0));
    }
}
