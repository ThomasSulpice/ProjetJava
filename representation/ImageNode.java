package representation;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageNode extends NodeDecorator{

    private String imgDir;
    public ImageNode(Event wrapped , String imgDir){
        super(wrapped);
        this.imgDir = imgDir;
    }

    @Override
    public void display(){
        super.display();
        SwingUtilities.invokeLater(() -> {
            try {
                BufferedImage image = ImageIO.read(new File(imgDir));
                ImageIcon icon = new ImageIcon(image);
                JLabel label = new JLabel(icon);

                JFrame frame = new JFrame("Image Display");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame.getContentPane().add(label, BorderLayout.CENTER);

                frame.setSize(image.getWidth(), image.getHeight());
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
            catch (IOException e) {
                System.out.println(e);
            }
        });
    }

}
