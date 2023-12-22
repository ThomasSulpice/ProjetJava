package univers;

import java.io.Serializable;

/** Swordsman hérite de la classe Character et implémente l'interface Serializable, car il fait partie de la sauvegarde.
 * @author Thomas Sulpice
 */
public class Swordsman extends Character implements Serializable {

    public Swordsman(String name){
        super(name , SkillDB.swordsmanSkills);
    }
}
