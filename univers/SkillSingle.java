package univers;

/** SkillAoE hérite de Skill, et permet de différencier les skills à cible unique des skills à cibles multiples.
 * @author Thomas Sulpice
 */
public class SkillSingle extends Skill{

    public SkillSingle(String name , double multiplier , double acc , int levelReq){
        super(name , multiplier , acc , levelReq);
    }

}
