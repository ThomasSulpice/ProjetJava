package game;

import representation.*;
import univers.*;
import univers.Character;

import java.io.Serializable;

import java.util.ArrayList;

/** Game contient toutes les informations nécessaires pour stocker une sauvegarde,
 * ainsi que des méthodes pour la mettre à jour.
 * @author Thomas Sulpice
 */
public class Game implements Serializable {

    protected univers.Character character;
    protected int chapter;
    protected int part;

    public Game(univers.Character character){
        this.character = character;
        chapter = 1;
        part = 1;
    }

    public univers.Character getCharacter() {
        return character;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public void addChapter(){
        chapter+=1;
        part = 1;
    }

    public void addPart(){
        part+=1;
    }

    public void setCharacter(univers.Character character){
        this.character = character;
    }
}
