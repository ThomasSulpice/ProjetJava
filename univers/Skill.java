package univers;

public class Skill {
    protected final String name;
    protected final double multiplier;
    protected final double acc;
    protected final int levelReq;

    public Skill(String name , double multiplier , double acc , int levelReq){
        this.name = name;
        this.multiplier = multiplier;
        this.acc = acc;
        this.levelReq = levelReq;
    }
}
