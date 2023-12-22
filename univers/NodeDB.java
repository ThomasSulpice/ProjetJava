package univers;

import com.almasb.fxgl.audio.Sound;
import representation.*;

/** NodeDB sert juste ici à stocker tous les noeuds apparaissant peu importe quel chemin de l'arbre de l'histoire est emprunté,
 * et permet donc de ne pas surcharger une autre classe.
 * @author Thomas Sulpice
 */
public class NodeDB {

    public final static TerminalNode gameOverNode = new TerminalNode(new String[]{"Game Over"});
    public final static Event ggNode =
            new ImageNode(new SoundNode(new TerminalNode(new String[] {"Félicitation! Vous avez remporté cette partie!"}) ,
                    "sound_db/victory.wav") ,  "image_db/victory.jpg");
    public final static TerminalNode nodeWell = new TerminalNode();
    public final static Event[] nodeArrayWell = new Event[]{nodeWell};

    public final static InnerNode Node4 = new InnerNode(new String[] {"Maintenant, allons tester vos nouvelles compétences. Suivez-moi."} , nodeWell);

    public static DecisionNode Node1 = new DecisionNode(new String[] {"Bienvenue aventurier! Quel est votre nom?"} , new Event[] {nodeWell} , new String[] {""} , true);




}
