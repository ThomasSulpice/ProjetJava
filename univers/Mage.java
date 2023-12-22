package univers;

import java.io.Serializable;

/** Mage hérite de la classe Character et implémente l'interface Serializable, car il fait partie de la sauvegarde.
 * @author Thomas Sulpice
 */
public class Mage extends Character implements Serializable {

    public Mage(String name){
        super(name , SkillDB.mageSkills);
    }
}
