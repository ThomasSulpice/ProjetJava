package univers;

public class Personnage {
    private final String Name;
    private int Level;
    private int Experience;

    public Personnage(){
        Name = "";
        Level = 1;
        Experience = 0;
    }

    public Personnage(String Name){
        this.Name = Name;
        Level = 1;
        Experience = 0;
    }
}
