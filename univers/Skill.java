package univers;

/** Un objet de la classe Skill contient tous les attributs nécessaires pour un skill utilisé lors d'un combat.
 * @author Thomas Sulpice
 */
public abstract class Skill {
    protected final String name;
    protected final double multiplier;
    protected final double acc;
    protected final int levelReq;

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public double getAcc() {
        return acc;
    }

    public int getLevelReq() {
        return levelReq;
    }

    public Skill(String name , double multiplier , double acc , int levelReq){
        this.name = name;
        this.multiplier = multiplier;
        this.acc = acc;
        this.levelReq = levelReq;
    }
}
