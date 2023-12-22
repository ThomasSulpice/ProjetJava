package main;

import game.Game;
import javafx.application.Application;
import javafx.application.Platform;
import representation.*;
import univers.*;
import game.*;

import java.io.*;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** Main contient le déroulement de l'histoire et gère l'éxecution du jeu et l'affichage du menu de sauvegarde.
 * @author Thomas Sulpice
 */
public class Main extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static ArrayList<Game> saves = new ArrayList<Game>();
    private static Game currentSave;
    private static ArrayList<Event> nodeList = new ArrayList<Event>();

    /** lance le reste de la partie après le choix du nom du personnage et de la classe
     */
    public static void playGame(){

        currentSave.addPart();
        if (currentSave.getChapter() == 1) {
            if (currentSave.getPart() == 2) {
                InnerNode Node0 = new InnerNode(new String[]{"Maintenant que vous avez choisi votre classe, allons tester vos compétences.", "Suivez-Moi", "...",
                        "Commencez par attaquer cet épouvantail."}, currentSave.getCharacter().combat(MonsterDB.epouvantail, NodeDB.ggNode));

                nodeList.add(Node0);
                nodeList.get(nodeList.size() - 1).display();
                currentSave.addPart();
            }
            if (currentSave.getPart() == 3) {
                Event tempNode1 = nodeList.get(nodeList.size() - 1).chooseNext();
                CombatNode Node1 = (CombatNode) tempNode1;

                nodeList.add(Node1);
                nodeList.get(nodeList.size() - 1).display();
                ((CombatNode) nodeList.get(nodeList.size() - 1)).combatLoop();
                currentSave.addChapter();
            }
        }
    }

    /** lance la partie et affiche le menu de sauvegarde après avoir configuré tous les boutons
     *
     * @param primaryStage
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        ObjectOutputStream firstOos = new ObjectOutputStream(new FileOutputStream(new File("saves/save.txt")));
        firstOos.writeObject(saves);

        primaryStage.setTitle("Menu");

        Button newGameButton = new Button("New Game");
        Button loadSaveButton = new Button("Load Save");
        Button deleteSaveButton = new Button("Delete Save");
        Button quitButton = new Button("Quit");

        // code exécuté après un click sur le bouton New Game du menu de sauvegarde
        newGameButton.setOnAction(e1 -> {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(new File("saves/save.txt")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                saves = (ArrayList<Game>) ois.readObject();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                ois.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            String[][] classes = new String[][]{{"épéiste", "une", "épée"}, {"archer", "un", "arc"}, {"mage", "un", "bâton magique"}};
            int classNbr = classes.length;
            univers.Character character;

            NodeDB.Node1.display();

            String characterName = NodeDB.Node1.getPotAnswers()[0];

            DecisionNode Node2 = new DecisionNode(new String[]{"Ravi de vous rencontrer, " + characterName + ".", "Choisissez donc une arme.", "épée / arc / baguette"},
                    NodeDB.nodeArrayWell, new String[]{"épée", "arc", "baguette"}, false);

            NodeDB.Node1.setPotNodes(new Event[]{Node2});

            Event[] NodeArray3 = new Event[classNbr];
            for (int i = 0; i < classNbr; i++) {
                String[] tempDesc = new String[]{"Vous avez donc choisi " + classes[i][1] + " " + classes[i][2] + "!",
                        "Vous serez désormais un " + classes[i][0] + "!"};
                Event tempEvent = new ImageNode(new SoundNode(new InnerNode(tempDesc, NodeDB.nodeWell), "sound_db/test.wav"), "image_db/test.jpg");
                NodeArray3[i] = tempEvent;
            }

            Node2.setPotNodes(NodeArray3);
            Node2.display();

            if (Node2.getAnswerNbr() == 0) {
                character = new Swordsman(characterName);
            } else if (Node2.getAnswerNbr() == 1) {
                character = new Archer(characterName);
            } else {
                character = new Mage(characterName);
            }
            Event Node3 = Node2.chooseNext();
            Node3.display();

            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("saves/save.txt")));
                currentSave = new Game(character);
                saves.add(currentSave);
                oos.writeObject(saves);
                playGame();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        // code exécuté après un click sur le bouton Load Save du menu de sauvegarde
        loadSaveButton.setOnAction(e2 -> {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(new File("saves/save.txt")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                saves = (ArrayList<Game>) ois.readObject();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                ois.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            ArrayList<Button> saveButtons = new ArrayList<Button>();

            Platform.runLater(() -> {
                Stage saveStage = new Stage();
                saveStage.setTitle("Saves");

                for (Game save : saves) {
                    String buttonTitle = save.getCharacter().getName() + " / lvl" + String.valueOf(save.getCharacter().getLevel()) + " / " + "Chapter " + save.getChapter() +
                            " Part " + String.valueOf(save.getPart());
                    saveButtons.add(new Button(buttonTitle));
                    saveButtons.get(saveButtons.size() - 1).setOnAction(e -> {
                        currentSave = save;
                        saveStage.close();
                        playGame();
                    });
                }

                VBox saveLayout = new VBox(10);
                for (Button button : saveButtons) {
                    saveLayout.getChildren().add(button);
                }

                Scene saveScene = new Scene(saveLayout, 300, 200);
                saveStage.setScene(saveScene);
                saveStage.show();
            });
        });


        // code exécuté après un click sur le bouton Delete Save du menu de sauvegarde
        deleteSaveButton.setOnAction(e3 -> {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(new File("saves/save.txt")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                saves = (ArrayList<Game>) ois.readObject();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                ois.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            ArrayList<Button> saveButtons = new ArrayList<Button>();

            Platform.runLater(() -> {
                Stage saveStage = new Stage();
                saveStage.setTitle("Saves");

                for (Game save : saves) {
                    String buttonTitle = save.getCharacter().getName() + " / lvl" + String.valueOf(save.getCharacter().getLevel()) + " / " + "Chapter " + save.getChapter() +
                            " Part " + String.valueOf(save.getPart());
                    saveButtons.add(new Button(buttonTitle));
                    saveButtons.get(saveButtons.size() - 1).setOnAction(e -> {
                        saves.remove(save);
                        saveStage.close();
                        ObjectOutputStream oos = null;
                        try {
                            oos = new ObjectOutputStream(new FileOutputStream(new File("saves/save.txt")));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            oos.writeObject(saves);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    });
                }

                VBox saveLayout = new VBox(10);
                for (Button button : saveButtons) {
                    saveLayout.getChildren().add(button);
                }

                Scene saveScene = new Scene(saveLayout, 300, 200);
                saveStage.setScene(saveScene);
                saveStage.show();
            });
        });

        // code exécuté après un click sur le bouton Quit du menu de sauvegarde
        quitButton.setOnAction(e4 -> {
            primaryStage.close();
            System.exit(0);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(newGameButton , loadSaveButton , deleteSaveButton , quitButton);

        Scene scene = new Scene(layout , 300 , 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
