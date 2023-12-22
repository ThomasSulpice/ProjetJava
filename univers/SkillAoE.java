package univers;

/** SkillAoE hérite de Skill, et permet de différencier les skills à cibles mutliples des skills à cible unique.
 * Ne contient rien pour l'instant, mais pourrait par exemple contenir le nombre maximal de cibles touchées.
 * @author Thomas Sulpice
 */
public class SkillAoE extends Skill{

    public SkillAoE(String name , double multiplier , double acc , int levelReq){
        super(name , multiplier , acc , levelReq);
    }
}
