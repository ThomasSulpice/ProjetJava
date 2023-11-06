package univers;

public class SkillAoE extends Skill{
    private double effectiveMltplr;

    public SkillAoE(String name , double multiplier , double acc , int levelReq){
        super(name , multiplier , acc , levelReq);
        effectiveMltplr = multiplier / 2;
    }
}
