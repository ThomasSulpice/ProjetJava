package univers;

import representation.TerminalNode;

public class SkillDB {

    public final static SkillSingle etincelle = new SkillSingle("Etincelle" , 0.9 , 0.8 , 1);
    public final static SkillSingle flammeche = new SkillSingle("Flammèche" , 1.0 , 0.9 , 4);
    public final static SkillSingle lanceflamme = new SkillSingle("Lance-Flamme" , 1.2 , 1.0 , 7);
    public final static SkillAoE bouledefeu = new SkillAoE("Boule de feu" , 1.0 , 0.9 , 10);

    public final static Skill[] mageSkills = new Skill[] {etincelle , flammeche , lanceflamme , bouledefeu};


    public final static SkillSingle coupdepee = new SkillSingle("Coup d'épée" , 0.8 , 0.9 , 1);
    public final static SkillSingle estoc = new SkillSingle("Estoc" , 0.9 , 1.0 , 4);
    public final static SkillSingle taille = new SkillSingle("Taille" , 1.2 , 1.0 , 7);
    public final static SkillAoE tranche = new SkillAoE("Tranche" , 1.0 , 0.9 , 10);

    public final static Skill[] swordsmanSkills = new Skill[] {coupdepee , estoc , taille , tranche};


    public final static SkillSingle tirbasique = new SkillSingle("Tir basique" , 0.8 , 0.9 , 1);
    public final static SkillSingle flechepercante = new SkillSingle("Flèche perçante" , 0.9 , 1.0 , 4);
    public final static SkillSingle tirmultiple = new SkillSingle("Tir multiple" , 1.3 , 0.9 , 7);
    public final static SkillAoE pluiedefleches = new SkillAoE("Pluie de flèches" , 1.0 , 0.9 , 10);

    public final static Skill[] archerSkills = new Skill[] {coupdepee , estoc , taille , tranche};
}
