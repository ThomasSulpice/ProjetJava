package univers;

import java.io.Serializable;

/** Archer hérite de la classe Character et implémente l'interface Serializable, car il fait partie de la sauvegarde.
 * @author Thomas Sulpice
 */
public class Archer extends Character implements Serializable {

    public Archer(String name){
        super(name , SkillDB.archerSkills);
    }
}
