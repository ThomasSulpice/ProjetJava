package representation;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class SoundNode extends NodeDecorator{

    private String soundDir;

    public SoundNode(Event wrapped , Event node , String soundDir){
        super(wrapped , node);
        this.soundDir = soundDir;
    }

    @Override
    public void display(){
        super.display();
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(soundDir));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

}
